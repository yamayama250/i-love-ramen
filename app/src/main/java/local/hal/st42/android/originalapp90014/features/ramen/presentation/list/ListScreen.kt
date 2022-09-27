package local.hal.st42.android.originalapp90014.features.ramen.presentation.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

import local.hal.st42.android.originalapp90014.features.ramen.presentation.list.component.*

@Composable
fun ListScreen(navController: NavController) {
    Scaffold(
        topBar = { AppBar() },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "店舗を追加する") },
                onClick = { navController.navigate("create") },
                icon = { Icon(Icons.Filled.Add,"") }
            )
        }
    ) {
        Column {
            var selectedTabIndex by remember { mutableStateOf(0) }

            TabRow(
                selectedTabIndex = selectedTabIndex,
                backgroundColor = MaterialTheme.colors.primary
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
                            color = if (selectedTabIndex == 0) Color.White else Color.Gray
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
                            color = if (selectedTabIndex == 1) Color.White else Color.Gray
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
                            color = if (selectedTabIndex == 2) Color.White else Color.Gray
                        )
                    }
                )
            }

            LazyColumn {
                when(selectedTabIndex) {
                    0 -> {
                        items(5) { item ->
                            ListColumn(navController)
                            Divider()
                        }
                    }
                    1 -> {
                        items(2) { item ->
                            ListColumn(navController)
                            Divider()
                        }
                    }
                    2 -> {
                        items(3) { item ->
                            ListColumn(navController)
                            Divider()
                        }
                    }
                }
            }
        }
    }
}
