package dev.janssenbatista.enfburnout.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties

@Composable
fun ResultDialog(points: Int = 0, onClose: () -> Unit = {}) {
    val answer = when {
        points < 50 -> "Pelo que foi respondido no questionário, você não está apresentando sinais de esgotamento profissional!"
        points in 50..70 -> "Pelo que foi respondido no questionário, você está apresentando alguns sinais de esgotamento profissional!"
        else -> "Pelo que foi respondido no questionário, você está apresentando grandes sinais de esgotamento profissional!"
    }
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            Button(onClick = onClose) {
                Text(text = "Fechar")
            }
        },
        title = {
            Text(text = answer, fontWeight = FontWeight.Medium)
        },
        text = {
            Text(
                text = "*Esse questionário não é destinado para fins de diagnóstico, sua utilização é de teste piloto para melhor aperfeiçoamento",
                color = MaterialTheme.colorScheme.error
            )
        },
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
    )
}

@Preview
@Composable
fun ResultDialogPreview() {
    ResultDialog()
}