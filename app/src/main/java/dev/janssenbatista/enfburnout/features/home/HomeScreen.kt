package dev.janssenbatista.enfburnout.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.janssenbatista.enfburnout.R
import dev.janssenbatista.enfburnout.features.talk.TalkScreen

object HomeScreen : Screen {
    private fun readResolve(): Any = HomeScreen
    const val TITLE = "Síndrome de Burnout"

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.burnout_pic),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "O que é?")
            }
            OutlinedButton(
                onClick = { navigator.push(TalkScreen) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text(text = "Vamos Conversar?")
            }
        }
    }

}