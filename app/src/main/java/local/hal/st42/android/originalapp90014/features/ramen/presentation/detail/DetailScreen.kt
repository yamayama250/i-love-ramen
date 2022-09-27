package local.hal.st42.android.originalapp90014.features.ramen.presentation.detail

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import local.hal.st42.android.originalapp90014.features.ramen.presentation.detail.component.DSAppBar

@Composable
fun DetailScreen(navController: NavController) {
    Scaffold(
        topBar = { DSAppBar(navController = navController) }
    ) {

    }
}