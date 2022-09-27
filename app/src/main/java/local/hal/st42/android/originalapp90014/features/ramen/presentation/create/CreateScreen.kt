package local.hal.st42.android.originalapp90014.features.ramen.presentation.create

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import local.hal.st42.android.originalapp90014.common_component.InfoBody
import local.hal.st42.android.originalapp90014.features.ramen.presentation.create.component.CSAppBar
import local.hal.st42.android.originalapp90014.features.ramen.viewmodel.MainViewModel
import local.hal.st42.android.originalapp90014.features.ramen.viewmodel.MainViewModelFactory
import local.hal.st42.android.originalapp90014.rememberRamenState
import java.sql.Date

@Composable
fun CreateScreen(
    navController: NavController,
    factory: MainViewModelFactory,
    mainViewModel: MainViewModel = viewModel(factory = factory)
) {
    val ramenState = rememberRamenState(
        name = "",
        address = "",
        visitDate = Date(System.currentTimeMillis()),
        category = "未選択",
        note = ""
    )

    Scaffold(
        topBar = { CSAppBar(navController, ramenState, mainViewModel) }
    ) {
        InfoBody(ramenState)
    }
}