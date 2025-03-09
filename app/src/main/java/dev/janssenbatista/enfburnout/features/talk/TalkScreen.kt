package dev.janssenbatista.enfburnout.features.talk

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.janssenbatista.enfburnout.components.PrivacyPolicyDialog
import dev.janssenbatista.enfburnout.components.Question
import dev.janssenbatista.enfburnout.components.QuestionHintDialog
import dev.janssenbatista.enfburnout.components.ResultDialog
import dev.janssenbatista.enfburnout.features.home.HomeScreen
import org.koin.androidx.compose.koinViewModel

object TalkScreen : Screen {
    private fun readResolve(): Any = TalkScreen

    const val TITLE = "Vamos Conversar?"

    private val questions = listOf(
        "Com que frequência o seu trabalho lhe deixa triste?",
        "Com que frequência você sente que o seu trabalho te estressa?",
        "Com que frequência você sente que o ambiente de trabalho te esgota emocionalmente e fisicamente?",
        "Com que frequência você sente que lidar com colegas de trabalho ou o público alvo te deixa exausto?",
        "Você sente que seu trabalho te faz feliz?",
        "Você sente que teu trabalho faz a diferença para o outro?",
        "Você se sente valorizado no ambiente de trabalho?",
        "Você acha que recebe o valor salarial adequado para a sua função no trabalho?",
        "Você acha que o seu trabalho prejudica as suas relações pessoais e interpessoais?",
        "Você já sentiu que o seu trabalho prejudica a sua empatia?",
        "Você já se sentiu como se estivesse desconectado do seu corpo durante o trabalho?"
    )

    @Composable
    override fun Content() {

        val talkViewModel: TalkViewModel = koinViewModel<TalkViewModel>()
        val state by talkViewModel.talkState.collectAsState()
        val content = LocalContext.current
        val navigator = LocalNavigator.currentOrThrow
        var isPrivacyPolicyDialogVisible by remember {
            mutableStateOf(true)
        }

        Column(
            Modifier
                .verticalScroll(rememberScrollState())
        ) {
            questions.forEachIndexed { index, question ->
                Question(
                    title = "${index + 1} - $question",
                    showDivider = index != questions.size - 1
                ) { selectedItem ->
                    state.setAnswer(index, selectedItem)
                }
            }
            Button(
                onClick = { state.onSend() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 8.dp)
            ) {
                Text(text = "Ver Resultado")
            }

        }
        if (isPrivacyPolicyDialogVisible) {
            PrivacyPolicyDialog(
                onDismissRequestClick = { navigator.replace(HomeScreen) },
                onConfirmButtonClick = { isPrivacyPolicyDialogVisible = false })
        }
        if (state.errorMessage.isNotBlank()) {
            Toast.makeText(content, state.errorMessage, Toast.LENGTH_SHORT).show()
        }
        if (state.points != 0) {
            Log.d("POINTS", state.points.toString())
            ResultDialog(points = state.points, onClose = {
                state.setPoints(0)
                navigator.pop()
            })
        }
    }
}