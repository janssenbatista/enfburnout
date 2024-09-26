package dev.janssenbatista.enfburnout.features.talk

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TalkViewModel : ViewModel() {

    private val _talkState = MutableStateFlow(TalkState())
    val talkState = _talkState.asStateFlow()

    init {
        _talkState.update {
            it.copy(setAnswer = { questionIndex, value ->
                _talkState.update { state ->
                    state.copy(answers = state.answers.mapIndexed { index, oldValue ->
                        if (index == questionIndex) value else oldValue
                    }, errorMessage = "")
                }
            }, onSend = {
                _talkState.value.answers.forEachIndexed { index, answer ->
                    if (answer == 0) {
                        _talkState.update { state ->
                            state.copy(errorMessage = "A questão ${index + 1} não foi respondida")
                        }
                        return@copy
                    }
                }
            })
        }

    }
}

data class TalkState(
    val answers: List<Int> = List(10) { 0 },
    val errorMessage: String = "",
    val answersSend: Boolean = false,
    val setAnswer: (Int, Int) -> Unit = { _, _ -> },
    val onSend: () -> Unit = {}
)