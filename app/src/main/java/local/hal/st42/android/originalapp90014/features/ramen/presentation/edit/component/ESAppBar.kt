package local.hal.st42.android.originalapp90014.features.ramen.presentation.edit.component

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ESAppBar(navController: NavController) {
    TopAppBar(
        elevation = 0.dp,
        title = { Text(text = "店舗情報編集") },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = { navController.navigate("list") }) {
                Icon(Icons.Default.Delete, contentDescription = "")
            }
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.Default.Check, contentDescription = "")
            }
        }
    )
}