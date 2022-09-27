package local.hal.st42.android.originalapp90014.common_component

import android.annotation.SuppressLint
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
import local.hal.st42.android.originalapp90014.RamenState
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
@Composable
fun InfoBody(ramenState: RamenState) {
    val visitSdf = SimpleDateFormat("yyyy年MM月dd日")

    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = ramenState.visitDate.time
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH) + 1
    val day = calendar.get(Calendar.DATE)

    var date by remember { mutableStateOf("${year}年${month}月${day}日") }
    // 一度Stateから引っ張ってこないと描写されない？のでゴリ押し
    date = visitSdf.format(ramenState.visitDate)

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, yyyy: Int, mm: Int, dd: Int ->
            date = "${yyyy}年${mm + 1}月${dd}日"
            calendar.set(yyyy, mm, dd)
            val millis = calendar.timeInMillis
            ramenState.visitDate = Date(millis)
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE)
    )

    Column(
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        OutlinedTextField(
            value = ramenState.name,
            onValueChange = { ramenState.name = it },
            label = { Text(text = "店名") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )
        OutlinedTextField(
            value = ramenState.address,
            onValueChange = { ramenState.address = it },
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
                ShowDropdownMenu(ramenState)
            }
        }
        OutlinedTextField(
            value = ramenState.note,
            onValueChange = { ramenState.note = it },
            label = { Text(text = "メモ") },
            modifier = Modifier
                .weight(1.0f, true)
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )
    }
}

@Composable
fun ShowDropdownMenu(ramenState: RamenState) {
    var expanded by remember { mutableStateOf(false)}

    Text(
        text = "カテゴリー：${ramenState.category}",
        fontSize = 12.sp,
        modifier = Modifier.clickable { expanded = true }
    )
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        DropdownMenuItem(onClick = {
            ramenState.category = "家系　"
            expanded = false
        }) {
            Text(text = "家系")
        }
        DropdownMenuItem(onClick = {
            ramenState.category = "二郎系"
            expanded = false
        }) {
            Text(text = "二郎系")
        }
    }
}