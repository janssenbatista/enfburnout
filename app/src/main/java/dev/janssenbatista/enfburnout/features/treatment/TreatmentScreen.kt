package dev.janssenbatista.enfburnout.features.treatment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import dev.janssenbatista.enfburnout.R
import dev.janssenbatista.enfburnout.components.Subtitle

object TreatmentScreen : Screen {
    private fun readResolve(): Any = TreatmentScreen
    const val TITLE = "Tratamento"

    @Composable
    override fun Content() {
        Column(
            Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 32.dp)
                .verticalScroll(rememberScrollState())) {
            Subtitle(text = stringResource(R.string.medicinal))
            Text(text = stringResource(R.string.medicinal_content))
            Subtitle(text = stringResource(R.string.therapeutic))
            Text(text = stringResource(R.string.therapeutic_content))
            Subtitle(text = stringResource(R.string.follow_up))
            Text(text = stringResource(R.string.follow_up_content))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TreatmentScreenPreview() {
    TreatmentScreen.Content()
}