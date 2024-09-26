package dev.janssenbatista.enfburnout.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuestionHintDialog(onDismissRequestClick: () -> Unit, onConfirmButtonClick: () -> Unit) {
    val answers = listOf(
        "Nunca",
        "Poucas vezes",
        "Poucas vezes ao mês",
        "Uma vez ao mês",
        "Poucas vezes por semana",
        "Sempre"
    )
    AlertDialog(onDismissRequest = onDismissRequestClick, confirmButton = {
        TextButton(onClick = onConfirmButtonClick) {
            Text(text = "OK")
        }
    }, text = {
        Column {
            Text(
                text = "Leia com atenção e marque a alternativa mais condizente com o sentimento mais frequente:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            answers.forEachIndexed { index, item ->
                Text(
                    text = "${index + 1} - $item",
                    textAlign = TextAlign.Center,
                    color = Color.Unspecified.copy(alpha = 0.6f),
                    fontSize = 16.sp
                )
            }
        }
    })
}

@Preview(showBackground = false)
@Composable
fun PreviewQuestionHintDialog() {
    QuestionHintDialog({}, {})
}