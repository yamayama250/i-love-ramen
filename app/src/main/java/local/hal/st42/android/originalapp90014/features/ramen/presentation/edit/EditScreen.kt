package local.hal.st42.android.originalapp90014.features.ramen.presentation.edit

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import local.hal.st42.android.originalapp90014.common_component.InfoBody
import local.hal.st42.android.originalapp90014.features.ramen.presentation.edit.component.ESAppBar
import local.hal.st42.android.originalapp90014.features.ramen.viewmodel.MainViewModel
import local.hal.st42.android.originalapp90014.features.ramen.viewmodel.MainViewModelFactory
import local.hal.st42.android.originalapp90014.rememberRamenState
import local.hal.st42.android.originalapp90014.util.initRamen

@Composable
fun EditScreen(
    navController: NavController,
    factory: MainViewModelFactory,
    mainViewModel: MainViewModel = viewModel(factory = factory),
    id: Int
) {
    // 削除後、遷移前に再描画がかかってしまいNULLエラーがでる
    // 今の僕の力では直せないのでNULLチェックでゴリ押ししてる
    // どうすればいいんだ
    val ramen = mainViewModel.findById(id).collectAsState(initial = initRamen()).value
        ?: initRamen()

    val ramenState = rememberRamenState(
        name = ramen.name,
        address = ramen.address,
        visitDate = ramen.visitDate,
        category = ramen.category,
        note = ramen.note
    )

    Scaffold(
        topBar = { ESAppBar(
            navController = navController,
            ramenState = ramenState,
            vm = mainViewModel,
            id = id,
            registry = ramen.registryDate
        ) }
    ) {
        InfoBody(ramenState)
    }
}