package local.hal.st42.android.originalapp90014.features.ramen.presentation.detail

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SimpleDateFormat")
@Composable
fun DetailScreen(
    navController: NavController,
    factory: MainViewModelFactory,
    mainViewModel: MainViewModel = viewModel(factory = factory),
    id: Int
) {
    Scaffold(
        topBar = { DSAppBar(navController = navController, id) },
    ) {
        val ramen = mainViewModel.findById(id).collectAsState(initial = initRamen()).value

        Column(
            modifier = Modifier
                .padding(it)
                .padding(12.dp)
        ) {
            val visitSdf = SimpleDateFormat("yyyy年MM月dd日")
            val sdf = SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss")

            Text(text = "ID", color = Color.Gray, fontSize = 12.sp)
            Text(text = "${ramen.id}", fontSize = 16.sp)

            Text(text = "店舗名", color = Color.Gray, fontSize = 12.sp)
            Text(text = ramen.name, fontSize = 16.sp)

            Text(text = "住所", color = Color.Gray, fontSize = 12.sp)
            Text(text = ramen.address, fontSize = 16.sp)

            Text(text = "行った日", color = Color.Gray, fontSize = 12.sp)
            Text(text = visitSdf.format(ramen.visitDate), fontSize = 16.sp)

            Text(text = "カテゴリー", color = Color.Gray, fontSize = 12.sp)
            Text(text = ramen.category, fontSize = 16.sp)

            Text(text = "メモ", color = Color.Gray, fontSize = 12.sp)
            Text(text = ramen.note, fontSize = 16.sp)

            Spacer(modifier = Modifier.weight(1f))

            Text(text = "登録日", color = Color.Gray, fontSize = 12.sp)
            Text(text = sdf.format(ramen.registryDate), fontSize = 16.sp)

            Text(text = "更新日: ", color = Color.Gray, fontSize = 12.sp)
            Text(text = sdf.format(ramen.updateDate), fontSize = 16.sp)
        }
    }
}