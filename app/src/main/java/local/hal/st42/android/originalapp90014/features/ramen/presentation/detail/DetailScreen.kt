package local.hal.st42.android.originalapp90014.features.ramen.presentation.detail

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import local.hal.st42.android.originalapp90014.features.ramen.presentation.detail.component.DSAppBar
import local.hal.st42.android.originalapp90014.features.ramen.viewmodel.MainViewModel
import local.hal.st42.android.originalapp90014.features.ramen.viewmodel.MainViewModelFactory
import local.hal.st42.android.originalapp90014.util.initRamen

@SuppressLint("SimpleDateFormat")
@Composable
fun DetailScreen(
    navController: NavController,
    factory: MainViewModelFactory,
    mainViewModel: MainViewModel = viewModel(factory = factory),
    id: Int
) {
    Scaffold(
        topBar = { DSAppBar(navController = navController, id) }
    ) {
        val ramen = mainViewModel.findById(id).collectAsState(initial = initRamen()).value
        
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            val visitSdf = SimpleDateFormat("yyyy年MM月dd日")
            val sdf = SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss")

            Row {
                Text(text = "ID: ", color = Color.Gray, fontSize = 20.sp)
                Text(text = "${ramen.id}", fontSize = 20.sp)
            }
            Row {
                Text(text = "店舗名: ", color = Color.Gray, fontSize = 20.sp)
                Text(text = ramen.name, fontSize = 20.sp)
            }
            Row {
                Text(text = "住所: ", color = Color.Gray, fontSize = 20.sp)
                Text(text = ramen.address, fontSize = 20.sp)
            }
            Row {
                Text(text = "行った日: ", color = Color.Gray, fontSize = 20.sp)
                Text(text = visitSdf.format(ramen.visitDate), fontSize = 20.sp)
            }
            Row {
                Text(text = "カテゴリー: ", color = Color.Gray, fontSize = 20.sp)
                Text(text = ramen.category, fontSize = 20.sp)
            }
            Row {
                Text(text = "メモ: ", color = Color.Gray, fontSize = 20.sp)
                Text(text = ramen.note, fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Row {
                Text(text = "登録日: ", color = Color.Gray, fontSize = 20.sp)
                Text(text = sdf.format(ramen.registryDate), fontSize = 20.sp)
            }
            Row {
                Text(text = "更新日: ", color = Color.Gray, fontSize = 20.sp)
                Text(text = sdf.format(ramen.updateDate), fontSize = 20.sp)
            }
        }
    }
}