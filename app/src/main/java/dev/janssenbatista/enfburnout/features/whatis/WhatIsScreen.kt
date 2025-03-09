package dev.janssenbatista.enfburnout.features.whatis

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import dev.janssenbatista.enfburnout.R
import dev.janssenbatista.enfburnout.components.Paragraph
import dev.janssenbatista.enfburnout.components.Subtitle
import dev.janssenbatista.enfburnout.components.Subtitle3
import dev.janssenbatista.enfburnout.features.whatis.WhatIsScreen.Content

object WhatIsScreen : Screen {
    private fun readResolve(): Any = WhatIsScreen
    const val TITLE = "O que é esgotamento profissional?"

    @Composable
    override fun Content() {
        Column(
            Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 32.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Paragraph(text = stringResource(R.string.burnout_content_1))
            Subtitle(text = "Exaustão Emocional")
            Image(
                painter = painterResource(id = R.drawable.exaustao_emocional),
                contentDescription = "imagem sobre exaustão emocional",
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Paragraph(text = stringResource(R.string.burnout_content_2))
            Subtitle(text = "Despersonalização")
            Image(
                painter = painterResource(id = R.drawable.despersonalizacao),
                contentDescription = "imagem sobre despersonalização",
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Paragraph(text = stringResource(R.string.burnout_content_3))
            Subtitle(text = "Redução da Realização Profissional")
            Image(
                painter = painterResource(id = R.drawable.reducao_realizacao_profissional),
                contentDescription = "imagem sobre despersonalização",
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Paragraph(text = stringResource(R.string.burnout_content_4))
            Paragraph(text = stringResource(R.string.burnout_content_4_1))
            Subtitle(text = "Possíveis causas do esgotamento profissional (burnout)")
            Paragraph(text = "Você sabe o que nome burnout significa? ")
            Image(
                painter = painterResource(id = R.drawable.significado_burnout),
                contentDescription = null,
                modifier = Modifier
                    .height(320.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Paragraph(text = "“Burnout” significa queimar-se ou consumir-se, levando a tradução mais fiel para o português do brasil, sendo conhecida síndrome de burnout ou esgotamento profissional.")
            Paragraph(text = "O meio que permeia o esgotamento profissional é o ambiente de trabalho, logo, tudo o que esteja relacionado ao ambiente laboral é passível para síndrome, pode acontecer a curto ou longo prazo, com sinais sutis que ao decorrer do tempo pode apresentar dano ao trabalhador. ")
            Subtitle3(text = "Mas o que pode levar ao esgotamento profissional?")
            Paragraph(text = stringResource(id = R.string.lista_esgotamento_profissional))
            Subtitle(text = "Diagnóstico")
            Image(
                painter = painterResource(id = R.drawable.diagnostico),
                contentDescription = "imagem sobre diagnóstico",
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Paragraph(text = "O diagnóstico do esgotamento profissional acontece após um longo apurado de sintomas compatíveis com as dimensões da síndrome da burnout, aplicação de teste, consultas e exames são essenciais para fechar o diagnóstico correto, sendo concedido pelo médico especialista em psiquiatria ou saúde do trabalhador e o psicólogo.")
            Paragraph(text = "Uma vez que o laudo é constatado, o trabalhador pode receber todos os benefícios previdenciários necessários para o afastamento de suas funções e tratamento correto da doença.")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewContent() {
    Content()
}