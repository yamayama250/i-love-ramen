package local.hal.st42.android.originalapp90014.features.ramen.presentation.list.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ListColumn(navController: NavController) {
    TextButton(
        onClick = { navController.navigate("detail") },
    ) {
        Column(
            Modifier
                .padding(6.dp)
                .fillMaxWidth()
        ) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "ここが店名なんですよ屋")
                Text(
                    fontSize = 10.sp,
                    text = "カテゴリ"
                )
            }
            Text(
                modifier = Modifier.padding(top = 4.dp),
                color = Color.Black,
                fontSize = 10.sp,
                text = "住所県住所市住所区1-1"
            )
        }
    }
}