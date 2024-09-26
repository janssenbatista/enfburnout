package dev.janssenbatista.enfburnout.features.whatis

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
import dev.janssenbatista.enfburnout.features.whatis.WhatIsScreen.Content

object WhatIsScreen : Screen {
    private fun readResolve(): Any = WhatIsScreen
    const val TITLE = "O que é Síndrome de Burnout?"

    @Composable
    override fun Content() {
        Column(
            Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.burnout_pic_2),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = stringResource(R.string.burnout_content_1))
            Text(text = stringResource(R.string.burnout_content_2))
            Text(text = stringResource(R.string.burnout_content_3))
            Text(text = stringResource(R.string.burnout_content_4))
            Subtitle(text = stringResource(R.string.burnout_subtitle_1))
            Image(
                painter = painterResource(id = R.drawable.burnout_pic_3),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = stringResource(R.string.burnout_content_5))
            Subtitle(text = stringResource(R.string.burnout_subtitle_2))
            Text(text = stringResource(R.string.burnout_content_6))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewContent() {
    Content()
}