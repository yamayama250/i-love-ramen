package local.hal.st42.android.originalapp90014.features.ramen.presentation.create.component

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import local.hal.st42.android.originalapp90014.RamenState
import local.hal.st42.android.originalapp90014.features.ramen.model.Ramen
import local.hal.st42.android.originalapp90014.features.ramen.viewmodel.MainViewModel
import java.sql.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CSAppBar(navController: NavController, ramenState: RamenState, vm: MainViewModel) {
    val context = LocalContext.current

    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        title = {
            Text(
                text = "店舗追加",
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        actions = {
            IconButton(onClick = {
                if (ramenState.name.trim() == "") {
                    Toast.makeText(context, "店舗名が入力されていません", Toast.LENGTH_SHORT).show()
                } else if (ramenState.category == "未選択") {
                    Toast.makeText(context, "カテゴリーが未選択です", Toast.LENGTH_SHORT).show()
                } else {
                    vm.insertRamen(
                        Ramen(
                            id = null,
                            name = ramenState.name,
                            address = ramenState.address,
                            visitDate = ramenState.visitDate,
                            category = ramenState.category,
                            note = ramenState.note,
                            registryDate = Date(System.currentTimeMillis()),
                            updateDate = Date(System.currentTimeMillis())
                        )
                    )
                    navController.navigateUp()
                }
            }) {
                Icon(
                    Icons.Default.Check,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    )
}