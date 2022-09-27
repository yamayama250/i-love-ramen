package local.hal.st42.android.originalapp90014.features.ramen.presentation.create

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import local.hal.st42.android.originalapp90014.common_component.InfoBody
import local.hal.st42.android.originalapp90014.features.ramen.presentation.create.component.CSAppBar

@Composable
fun CreateScreen(navController: NavController) {
    Scaffold(
        topBar = { CSAppBar(navController) }
    ) {
        InfoBody()
    }
}