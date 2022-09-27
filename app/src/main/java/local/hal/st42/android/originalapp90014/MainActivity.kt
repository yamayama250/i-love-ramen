package local.hal.st42.android.originalapp90014

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import local.hal.st42.android.originalapp90014.database.AppDatabase
import local.hal.st42.android.originalapp90014.features.ramen.presentation.create.CreateScreen
import local.hal.st42.android.originalapp90014.features.ramen.presentation.detail.DetailScreen
import local.hal.st42.android.originalapp90014.features.ramen.presentation.edit.EditScreen
import local.hal.st42.android.originalapp90014.features.ramen.presentation.list.ListScreen
import local.hal.st42.android.originalapp90014.features.ramen.repository.RamenRepositoryImpl
import local.hal.st42.android.originalapp90014.features.ramen.viewmodel.MainViewModel
import local.hal.st42.android.originalapp90014.features.ramen.viewmodel.MainViewModelFactory
import local.hal.st42.android.originalapp90014.ui.theme.OriginalApp90014Theme
import java.sql.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = AppDatabase.getInstance(application).ramenDAO()
        val repository = RamenRepositoryImpl(dao)
        val factory = MainViewModelFactory(repository)

        setContent {
            OriginalApp90014(factory)
        }
    }
}

@Composable
fun OriginalApp90014(factory: MainViewModelFactory) {
    val navController = rememberNavController()

    OriginalApp90014Theme {
        NavHost(navController = navController, startDestination = "list") {
            composable("list") {
                ListScreen(navController = navController, factory = factory)
            }
            composable("create") {
                CreateScreen(navController = navController, factory = factory)
            }
            composable(
                "detail/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) {
                val id = it.arguments?.getInt("id") ?: 0
                DetailScreen(navController = navController, factory = factory, id = id)
            }
            composable(
                "edit/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) {
                val id = it.arguments?.getInt("id") ?: 0
                EditScreen(navController = navController, factory = factory, id = id)
            }
        }
    }
}

class RamenState(name: String, address: String, visitDate: Date, category: String, note: String) {
    var name      by mutableStateOf(name)
    var address   by mutableStateOf(address)
    var visitDate by mutableStateOf(visitDate)
    var category  by mutableStateOf(category)
    var note      by mutableStateOf(note)

    companion object {
        val Saver: Saver<RamenState, *> = listSaver(
            save = { listOf(it.name, it.address, it.visitDate, it.category, it.note) },
            restore = {
                RamenState(it[0] as String, it[1] as String, it[2] as Date, it[3] as String, it[4] as String)
            }
        )
    }
}

@Composable
fun rememberRamenState(name: String, address: String, visitDate: Date, category: String, note: String) =
    rememberSaveable(name, address, visitDate, category, note, saver = RamenState.Saver) {
        RamenState(name, address, visitDate, category, note)
    }