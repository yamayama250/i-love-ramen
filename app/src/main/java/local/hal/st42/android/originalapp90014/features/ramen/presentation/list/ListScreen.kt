package local.hal.st42.android.originalapp90014.features.ramen.presentation.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import local.hal.st42.android.originalapp90014.features.ramen.presentation.list.component.AppBar
import local.hal.st42.android.originalapp90014.features.ramen.presentation.list.component.ListColumn
import local.hal.st42.android.originalapp90014.features.ramen.viewmodel.MainViewModel
import local.hal.st42.android.originalapp90014.features.ramen.viewmodel.MainViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavController,
    factory: MainViewModelFactory,
    mainViewModel: MainViewModel = viewModel(factory = factory)
) {
    Scaffold(
        topBar = { AppBar() },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "店舗を追加する") },
                onClick = { navController.navigate("create") },
                icon = { Icon(Icons.Filled.Add, "") }
            )
        }
    ) {
        val ramenList = mainViewModel.ramenList.collectAsState(initial = emptyList())
        val ramens = ramenList.value

        Column(
            modifier = Modifier.padding(it)
        ) {
            var selectedTabIndex by remember { mutableStateOf(0) }

            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Tab(
                    selected = selectedTabIndex == 0,
                    onClick = {
                        selectedTabIndex = 0
                    },
                    text = {
                        Text(
                            text = "全店舗",
                            fontWeight = FontWeight.Bold,
                            color = if (selectedTabIndex == 0) Color.White else MaterialTheme.colorScheme.outline
                        )
                    }
                )
                Tab(
                    selected = selectedTabIndex == 1,
                    onClick = {
                        selectedTabIndex = 1
                    },
                    text = {
                        Text(
                            text = "家系",
                            fontWeight = FontWeight.Bold,
                            color = if (selectedTabIndex == 1) Color.White else MaterialTheme.colorScheme.outline
                        )
                    }
                )
                Tab(
                    selected = selectedTabIndex == 2,
                    onClick = {
                        selectedTabIndex = 2
                    },
                    text = {
                        Text(
                            text = "二郎系",
                            fontWeight = FontWeight.Bold,
                            color = if (selectedTabIndex == 2) Color.White else MaterialTheme.colorScheme.outline
                        )
                    }
                )
            }

            LazyColumn {
                when (selectedTabIndex) {
                    0 -> {
                        items(ramens) { ramen ->
                            ListColumn(navController, ramen)
                            Divider()
                        }
                    }
                    1 -> {
                        items(ramens) { ramen ->
                            if (ramen.category == "家系　") {
                                ListColumn(navController, ramen)
                                Divider()
                            }
                        }
                    }
                    2 -> {
                        items(ramens) { ramen ->
                            if (ramen.category == "二郎系") {
                                ListColumn(navController, ramen)
                                Divider()
                            }
                        }
                    }
                }
            }
        }
    }
}
