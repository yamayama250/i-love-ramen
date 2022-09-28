package local.hal.st42.android.originalapp90014.features.ramen.presentation.list.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import local.hal.st42.android.originalapp90014.features.ramen.model.Ramen

@Composable
fun ListColumn(navController: NavController, ramen: Ramen) {
    TextButton(
        onClick = { navController.navigate("detail/${ramen.id}") },
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
                Text(text = ramen.name)
                Text(
                    fontSize = 10.sp,
                    text = ramen.category
                )
            }
            Text(
                modifier = Modifier.padding(top = 4.dp),
                color = Color.Black,
                fontSize = 10.sp,
                text = ramen.address
            )
        }
    }
}