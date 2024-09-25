package dev.janssenbatista.enfburnout.features.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.janssenbatista.enfburnout.R
import dev.janssenbatista.enfburnout.features.home.HomeScreen
import kotlinx.coroutines.delay

object SplashScreen : Screen {
    private fun readResolve(): Any = SplashScreen

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(key1 = Unit) {
            delay(3_000) // 3 seconds
            navigator.replace(HomeScreen)
        }

        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(
                    R.string.app_logo
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = "Enf",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.tertiary
                )
                Text(text = "Burnout", fontWeight = FontWeight.Medium, fontSize = 40.sp)
            }
        }
    }
}