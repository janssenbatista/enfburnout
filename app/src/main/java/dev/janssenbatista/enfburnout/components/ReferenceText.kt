package dev.janssenbatista.enfburnout.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ReferenceText(
    description: String,
    link: String?,
    accessAt: String?,
    onLinkClick: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
        append(description)
        append(" ")
        link?.let {
            pushStringAnnotation(tag = "URL", annotation = link)
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append(link)
            }
            pop()
            append(accessAt)
        }
    }

    Text(
        text = annotatedText,
        modifier = Modifier
            .clickable {
                annotatedText
                    .getStringAnnotations(
                        tag = "URL",
                        start = 0,
                        end = annotatedText.length
                    )
                    .firstOrNull()
                    ?.let {
                        onLinkClick()
                    }
            },
        fontSize = 16.sp,
        fontWeight = FontWeight.W500
    )
}