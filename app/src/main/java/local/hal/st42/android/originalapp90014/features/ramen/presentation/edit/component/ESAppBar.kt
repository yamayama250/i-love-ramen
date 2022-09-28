package local.hal.st42.android.originalapp90014.features.ramen.presentation.edit.component

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import local.hal.st42.android.originalapp90014.RamenState
import local.hal.st42.android.originalapp90014.features.ramen.model.Ramen
import local.hal.st42.android.originalapp90014.features.ramen.viewmodel.MainViewModel
import java.sql.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ESAppBar(
    navController: NavController,
    ramenState: RamenState,
    vm: MainViewModel,
    id: Int,
    registry: Date
) {
    val context = LocalContext.current

    val deleteDialog = remember { mutableStateOf(false) }

    if (deleteDialog.value) {
        AlertDialog(
            onDismissRequest = { deleteDialog.value = false },
            title = { Text(text = "いいですか？") },
            text = { Text(text = "削除していいですか？") },
            confirmButton = {
                TextButton(onClick = {
                    vm.deleteRamen(
                        Ramen(
                            id,
                            ramenState.name,
                            ramenState.address,
                            ramenState.visitDate,
                            ramenState.category,
                            ramenState.note,
                            registry,
                            Date(System.currentTimeMillis())
                        )
                    )
                    navController.navigate("list")

                }) {
                    Text(text = "削除")
                }
            },
            dismissButton = {
                TextButton(onClick = { deleteDialog.value = false }) {
                    Text(text = "キャンセル")
                }
            }
        )
    }

    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        title = { Text(text = "店舗情報編集", color = MaterialTheme.colorScheme.onPrimary) },
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
            IconButton(onClick = { deleteDialog.value = true }) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
            IconButton(onClick = {
                if (ramenState.name.trim() == "") {
                    Toast.makeText(context, "店舗名が入力されていません", Toast.LENGTH_SHORT).show()
                } else if (ramenState.category == "未選択") {
                    Toast.makeText(context, "カテゴリーが未選択です", Toast.LENGTH_SHORT).show()
                } else {
                    vm.updateRamen(
                        Ramen(
                            id,
                            ramenState.name,
                            ramenState.address,
                            ramenState.visitDate,
                            ramenState.category,
                            ramenState.note,
                            registry,
                            Date(System.currentTimeMillis())
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