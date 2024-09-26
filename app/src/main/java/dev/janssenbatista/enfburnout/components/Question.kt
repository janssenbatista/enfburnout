package dev.janssenbatista.enfburnout.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Question(
    modifier: Modifier = Modifier,
    title: String = "",
    showDivider: Boolean = true,
    onItemSelected: (Int) -> Unit
) {
    var selectedItem by remember {
        mutableIntStateOf(-1)
    }
    Column(modifier) {
        Text(text = title, fontSize = 18.sp, modifier = Modifier.padding(horizontal = 16.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(end = 24.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            listOf(1, 2, 3, 4, 5, 6).forEach { item ->
                Row(Modifier.clickable {
                    onItemSelected(item)
                    selectedItem = item
                }, verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = item == selectedItem, onClick = {
                        onItemSelected(item)
                        selectedItem = item
                    })
                    Text(text = item.toString())
                }
            }
        }
        if (showDivider) {
            HorizontalDivider(Modifier.padding(bottom = 8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewQuestion() {
    Question(title = "Qual a sua opnião sobre isso?") { }
}