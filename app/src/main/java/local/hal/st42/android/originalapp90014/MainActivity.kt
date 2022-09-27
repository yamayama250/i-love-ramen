package local.hal.st42.android.originalapp90014

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import local.hal.st42.android.originalapp90014.features.ramen.presentation.create.CreateScreen
import local.hal.st42.android.originalapp90014.features.ramen.presentation.detail.DetailScreen
import local.hal.st42.android.originalapp90014.features.ramen.presentation.edit.EditScreen
import local.hal.st42.android.originalapp90014.features.ramen.presentation.list.ListScreen
import local.hal.st42.android.originalapp90014.ui.theme.OriginalApp90014Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OriginalApp90014()
        }
    }
}

@Composable
fun OriginalApp90014() {
    val navController = rememberNavController()

    OriginalApp90014Theme {
        NavHost(navController = navController, startDestination = "list") {
            composable("list") {
                ListScreen(navController = navController)
            }
            composable("create") {
                CreateScreen(navController = navController)
            }
            composable("detail") {
                DetailScreen(navController = navController)
            }
            composable("edit") {
                EditScreen(navController = navController)
            }
        }
    }
}