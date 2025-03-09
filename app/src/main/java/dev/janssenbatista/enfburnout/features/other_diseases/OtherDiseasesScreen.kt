package dev.janssenbatista.enfburnout.features.other_diseases

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
import dev.janssenbatista.enfburnout.components.Subtitle

object OtherDiseasesScreen : Screen {
    private fun readResolve(): Any = OtherDiseasesScreen
    const val TITLE = "Outras Doenças"

    @Composable
    override fun Content() {
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = stringResource(R.string.other_content))
            Image(
                painter = painterResource(id = R.drawable.esgotamento_profissional),
                contentDescription = "imagem sobre outras doenças",
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Subtitle(text = stringResource(R.string.depression))
            Text(text = stringResource(R.string.depression_content))
            Subtitle(text = stringResource(R.string.stress))
            Text(text = stringResource(R.string.stress_content))
            Subtitle(text = stringResource(R.string.anxiety))
            Text(text = stringResource(R.string.anxiety_content))
        }
    }


}

@Preview(showBackground = true)
@Composable
fun OtherDiseasesPreview() {
    OtherDiseasesScreen.Content()
}

