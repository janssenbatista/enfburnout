package dev.janssenbatista.enfburnout.features.references

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import dev.janssenbatista.enfburnout.components.ReferenceText

object ReferencesScreen : Screen {
    private fun readResolve(): Any = ReferencesScreen
    const val TITLE = "Referências"

    private val references2 = listOf(
        Reference(description = "Gomez, C. M., Vasconcellos, L. C. F., Machado, J. M. H. Saúde do trabalhador: aspectos históricos, avanços e desafios no Sistema Único de Saúde. Ciência & Saúde Coletiva, 23(6), 1963–1970. 2018."),
        Reference(description = "GOMEZ, Carlos Minayo; VASCONCELLOS, Luiz Carlos Fadel de; MACHADO, Jorge Mesquita Huet. Saúde do trabalhador: aspectos históricos, avanços e desafios no Sistema Único de Saúde. Ciência & Saúde Coletiva, v. 23, p. 1963-1970, 2018."),
        Reference(
            description = "FERNANDES, M. A.; SOARES, L. M. D.; SILVA, J. S. Transtornos mentais associados ao trabalho de enfermagem: uma revisão integrativa brasileira. Rev Bras Med Trab., v. 16, n. 2, p. 218-224, 2016. Disponível em:",
            link = "http://www.rbmt.org.br/details/318/pt-BR/transtornos-mentais-associados-ao-trabalho-em-profissionais-de-enfermagem--uma-revisao-integrativa-brasileira",
            accessAt = ". Acesso em: 20 out. 2019."
        ),
        Reference(
            description = "SANTOS, E. N. et al. Saúde do Trabalhador no Ambiente Hospitalar: Fatores de Risco para a Síndrome de Burnout. Revista Nursing, v. 22n. 248, p. 2509-2513, 2018. Disponível em:",
            link = "https://pesquisa.bvsalud.org/portal/resource/pt/biblio-980649",
            accessAt = ". Acesso em: 25 set. 2019."
        ),
        Reference(
            description = "NOWROUZI, B. et al. Occupational Stress Management and Burnout Interventions in Nursing and Their Implications for Health Work Envorionments. Workplace Health e Safeth, v. 20, n. p. 10, 2015. Disponível em: ",
            link = "https://www.researchgate.net/publication/278731154_Occupational_Stress_Management_and_Burnout_Interventions_in_Nursing_and_Their_Implications_for_Health_Work_Environments_A_Literature_Review",
            accessAt = ". Acesso em: 10 nov. 2019."
        ),
        Reference(
            description = "PEREIRA, F. L. R. et al. Manifestações de ansiedade vivenciadas por estudantes de enfermagem. Rev Fun Care Online, v. 11, n. 4, p. 880-886, 2019. Disponível em: ",
            link = "https://pesquisa.bvsalud.org/portal/resource/pt/biblio-1005622",
            accessAt = ". Acesso em: 10 nov. 2019."
        ),
        Reference(
            description = "OLIVEIRA, E. B. et al. Estresse ocupacional e brunout em enfermeiros de um serviço de emergência: a organização do trabalho. Rev enferm UERJ, v. 25, e. 28842, p. 1-7, 2017. Disponível em: ",
            link = "https://www.e-publicacoes.uerj.br/index.php/enfermagemuerj/article/view/28842",
            accessAt = ". Acesso em: 03 set. 2019."
        ),
        Reference(
            description = "PEREIRA, M. M. A.; GOMES, A. R. S. Stress, burnout e avaliação cognitiva: estudo na classe de enfermagem. Arquivos Brasileiros de Psicológia, v. 68, n. 1, p. 72-83, 2016. Disponível em: ",
            link = "http://pepsic.bvsalud.org/scielo.php?script=sci_arttext&pid=S1809-52672016000100007",
            accessAt = ". Acesso em: 21 out. 2019."
        ),
        Reference(
            description = "FERNANDES, M. A.; SOARES, L. M. D.; SILVA, J. S. Transtornos mentais associados ao trabalho de enfermagem: uma revisão integrativa brasileira. Rev Bras Med Trab., v. 16, n. 2, p. 218-224, 2016. Disponível em: ",
            link = "http://www.rbmt.org.br/details/318/pt-BR/transtornos-mentais-associados-ao-trabalho-em-profissionais-de-enfermagem--uma-revisao-integrativa-brasileira",
            accessAt = ". Acesso em: 20 out. 2019."
        ),
        Reference(
            description = "RAMOS, F. R. S. et al. Aspectos sociodemográficos e laborais associados ao distresse moral em enfermeiros brasileiros. Acta Paul Enferm, v. 32, n. 4, p.406-415, 2019. Disponível em: ",
            link = "http://www.scielo.br/scielo.php?pid=S0103-21002019000400406&script=sci_arttext",
            accessAt = ". Acesso em: 25 set. 2019."
        ),
        Reference(
            description = "SANTANA, R. S. et al. Estresse ocupacional dos enfermeiros de urgência e emergência de um hospital público em Teresina (PI). Rev Bras Med Trab., v. 17, n. 1, p. 76-82, 2019. Disponível em: ",
            link = "http://www.rbmt.org.br/details/423/pt-BR/estresse-ocupacional-dos-enfermeiros-de-urgencia-e-emergencia-de-um-hospital-publico-de-teresina--pi-",
            accessAt = ". Acesso em: 22 set. 2019."
        )
    )

    @Composable
    override fun Content() {

        val context = LocalContext.current

        LazyColumn(Modifier.padding(horizontal = 16.dp).padding(bottom = 32.dp)) {
            itemsIndexed(references2) { index, reference ->
                ReferenceText(
                    description = reference.description,
                    link = reference.link,
                    accessAt = reference.accessAt
                ) {
                    reference.link?.let {
                        openLink(context, it)
                    }
                }
                if (index < references2.size - 1) {
                    HorizontalDivider(Modifier.padding(vertical = 16.dp))
                }
            }
        }
    }
}

private fun openLink(context: Context, link: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
    context.startActivity(intent)
}

data class Reference(
    val description: String,
    val link: String? = null,
    val accessAt: String? = null
)

@Preview(showBackground = true)
@Composable
fun ReferencesScreenPreview() {
    ReferencesScreen.Content()
}