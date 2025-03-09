package dev.janssenbatista.enfburnout.features.treatment

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import dev.janssenbatista.enfburnout.R
import dev.janssenbatista.enfburnout.components.Paragraph
import dev.janssenbatista.enfburnout.components.Subtitle
import dev.janssenbatista.enfburnout.components.Subtitle3

object TreatmentScreen : Screen {
    private fun readResolve(): Any = TreatmentScreen
    const val TITLE = "Tratamento"

    @Composable
    override fun Content() {
        Column(
            Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 32.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Subtitle(text = stringResource(R.string.medicinal))
            Image(
                painter = painterResource(id = R.drawable.medicamentoso),
                contentDescription = "imagem sobre tratamento medicamentoso",
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Paragraph(text = stringResource(R.string.medicinal_content))
            Subtitle(text = "Psicológico")
            Image(
                painter = painterResource(id = R.drawable.psicologico),
                contentDescription = "imagem sobre tratamento psicológico",
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Paragraph(text = stringResource(R.string.therapeutic_content))
            Subtitle(text = "Terapias Alternativas")
            Paragraph(text = "Você já ouviu falar sobre terapias alternativas? Te falo mais sobre o uso delas e como elas são auxiliares no processo de tratamento.")
            Subtitle3(text = "Meditação")
            Image(
                painter = painterResource(id = R.drawable.meditacao),
                contentDescription = "imagem sobre meditação",
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Paragraph(text = "O ato de meditar, traz consigo benefícios já comprovados pela ciência, melhora a respiração, acalma a ansiedade, desacelera os batimentos cardíacos e promove o auto controle. É uma atividade de exercício mental, rápida e de fácil acesso.")
            Subtitle3(text = "Aromaterapia")
            Image(
                painter = painterResource(id = R.drawable.aromaterapia),
                contentDescription = "imagem sobre aromaterapia",
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Paragraph(text = "Essa terapia quando associada a prática de massoterapia proporciona relaxamento do corpo e mente, mas ela também tem seu benefício apenas sendo difundida no ambiente ou no contato com a pele, a aromaterapia é a utilização da essência de óleo das ervas e flores medicinais que ajudam o paciente a relaxar, aliviar dores musculares e proporciona sensação de leveza.")
            Subtitle(text = "Prática de Exercícios Físicos")
            Image(
                painter = painterResource(id = R.drawable.exercicios_fisicos),
                contentDescription = "imagem sobre prática de exercícios físicos",
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Paragraph(text = "Exercitar o corpo é beneficiar a mente também, além de promover mobilidade, resistência e definição, a pratica de exercício físico libera endorfina, hormônio responsável pela sensação de felicidade, beneficia o sono e mantém o corpo ativo, logico, toda prática deve ser acompanhada por um profissional de educação física ou especialista da prática que o paciente desejar.")
            Subtitle(text = "Alimentação Saudável")
            Image(
                painter = painterResource(id = R.drawable.alimentacao_saudavel),
                contentDescription = "imagem sobre alimentação saudável",
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Paragraph(text = "Mas é claro que todo processo de autocuidado requer uma boa alimentação, regada de frutas, verduras, legumes, proteínas, fibras e ingestão de água. Com o auxílio de um profissional da nutrição, é possível regular o intestino, proporcionar saciedade e manter o corpo saudável sem precisar retirar alimentos que fazem parte da rotina do paciente, auxilia a promover hábitos saudáveis de compromisso com a sua alimentação.")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun TreatmentScreenPreview() {
    TreatmentScreen.Content()
}