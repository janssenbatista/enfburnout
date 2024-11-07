package dev.janssenbatista.enfburnout.features.talk

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.janssenbatista.enfburnout.BuildConfig
import dev.janssenbatista.enfburnout.models.ApiRequest
import dev.janssenbatista.enfburnout.services.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TalkViewModel(private val apiService: ApiService) : ViewModel() {

    private val _talkState = MutableStateFlow(TalkState())
    val talkState = _talkState.asStateFlow()

    init {
        _talkState.update {
            it.copy(
                setAnswer = { questionIndex, value ->
                    _talkState.update { state ->
                        state.copy(answers = state.answers.mapIndexed { index, oldValue ->
                            if (index == questionIndex) value else oldValue
                        }, errorMessage = "")
                    }
                },
                onSend = {
                    _talkState.value.answers.forEachIndexed { index, answer ->
                        if (answer == 0) {
                            _talkState.update { state ->
                                state.copy(errorMessage = "A questão ${index + 1} não foi respondida")
                            }
                            return@copy
                        }
                    }
                    viewModelScope.launch {
                        apiService.sendAnswers(
                            apiKey = BuildConfig.API_KEY,
                            ApiRequest(answers = _talkState.value.answers.toIntArray())
                        )
                    }
                    val result =
                        _talkState.value.answers.reduce { acc, next -> acc + next }
                    _talkState.update { state ->
                        state.copy(points = result)
                    }
                },
                setPoints = { points ->
                    _talkState.update { state ->
                        state.copy(points = points)
                    }
                })
        }

    }
}

data class TalkState(
    val answers: List<Int> = List(10) { 0 },
    val errorMessage: String = "",
    val answersSend: Boolean = false,
    val points: Int = 0,
    val setAnswer: (Int, Int) -> Unit = { _, _ -> },
    val onSend: () -> Unit = {},
    val setPoints: (Int) -> Unit = {}
)