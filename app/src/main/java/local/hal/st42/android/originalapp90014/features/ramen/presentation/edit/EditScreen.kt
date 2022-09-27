package local.hal.st42.android.originalapp90014.features.ramen.presentation.edit

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import local.hal.st42.android.originalapp90014.common_component.InfoBody
import local.hal.st42.android.originalapp90014.features.ramen.presentation.edit.component.ESAppBar

@Composable
fun EditScreen(navController: NavController) {
    Scaffold(
        topBar = { ESAppBar(navController = navController) }
    ) {
        InfoBody()
    }
}