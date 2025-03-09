package dev.janssenbatista.enfburnout.features.support_services

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import dev.janssenbatista.enfburnout.R
import dev.janssenbatista.enfburnout.components.Paragraph

object SupportServicesScreen : Screen {
    private fun readResolve(): Any = SupportServicesScreen
    const val TITLE = "Serviços de Apoio"

    @Composable
    override fun Content() {
        Column(
            Modifier
                .padding(horizontal = 16.dp)
                .padding(end = 16.dp)
                .verticalScroll(
                    rememberScrollState()
                ), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.servicos_de_apoio),
                contentDescription = "imagem sobre serviços de apoio",
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Paragraph(text = stringResource(R.string.support_content_1))
            Paragraph(text = stringResource(R.string.support_content_1_2))
            Paragraph(text = stringResource(R.string.support_content_1_3))
            Paragraph(text = stringResource(R.string.support_content_1_4))
            Paragraph(text = stringResource(R.string.support_content_1_5))
            Paragraph(text = stringResource(R.string.support_content_1_6))
            Text(
                text = stringResource(R.string.support_content_2),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.support_content_3),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.support_content_4),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Centro de Referência a Saúde do Trabalhador - Cerest",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Instituto Nacional do Seguro Social – 135",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SupportServicesScreenPreview() {
    SupportServicesScreen.Content()
}