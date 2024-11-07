package dev.janssenbatista.enfburnout.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties

@Composable
fun ResultDialog(points: Int = 0, onClose: () -> Unit = {}) {
    AlertDialog(onDismissRequest = {}, confirmButton = {
        Button(onClick = onClose) {
            Text(text = "Fechar")
        }
    }, title = {
        Text(text = "Sua pontuação foi:")
    }, text = {
        Text(
            text = points.toString(),
            fontSize = 64.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }, properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false))
}

@Preview
@Composable
fun ResultDialogPreview() {
    ResultDialog()
}