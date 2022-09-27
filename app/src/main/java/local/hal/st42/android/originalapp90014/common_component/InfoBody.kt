package local.hal.st42.android.originalapp90014.common_component

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

@Composable
fun InfoBody() {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH) + 1
    val day = calendar.get(Calendar.DATE)

    var date by remember { mutableStateOf("${year}年${month}月${day}日") }

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, yyyy: Int, mm: Int, dd: Int ->
            date = "${yyyy}年${mm + 1}月${dd}日"
            calendar.set(yyyy, mm, dd)
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE)
    )

    Column(
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        var name by remember { mutableStateOf("") }
        var address by remember { mutableStateOf("") }
        var note by remember { mutableStateOf("") }

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "店名") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )
        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text(text = "住所") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 4.dp)
        ) {
            Text(
                text = "行った日：$date",
                fontSize = 12.sp,
                modifier = Modifier.clickable { datePickerDialog.show() }
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ShowDropdownMenu()
            }
        }
        OutlinedTextField(
            value = note,
            onValueChange = { note = it },
            label = { Text(text = "メモ") },
            modifier = Modifier
                .weight(1.0f, true)
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )
    }
}

@Composable
fun ShowDropdownMenu() {
    var expanded by remember { mutableStateOf(false)}
    var category by remember { mutableStateOf("未選択") }

    Text(
        text = "カテゴリー：$category",
        fontSize = 12.sp,
        modifier = Modifier.clickable { expanded = true }
    )
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        DropdownMenuItem(onClick = {
            category = "　家系"
            expanded = false
        }) {
            Text(text = "家系")
        }
        DropdownMenuItem(onClick = {
            category = "二郎系"
            expanded = false
        }) {
            Text(text = "二郎系")
        }
    }
}