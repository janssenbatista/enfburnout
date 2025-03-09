package dev.janssenbatista.enfburnout.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun Paragraph(text: String) {
    Text(text = text, style = TextStyle(lineHeight = 24.sp))
}