package com.example.dhouhaelaouni.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dhouhaelaouni.data.Category
import com.example.dhouhaelaouni.data.Difficulty
import com.example.dhouhaelaouni.data.Question
import com.example.dhouhaelaouni.data.QuestionRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * UI State for the Quiz Screen.
 * Uses Unidirectional Data Flow (UDF) to maintain consistency.
 */
data class QuizUiState(
    val questions: List<Question> = emptyList(),
    val currentIndex: Int = 0,
    val selectedAnswerIndex: Int? = null,
    val score: Int = 0,
    val timeLeft: Int = 15,
    val timerEnabled: Boolean = true,
    val showFunFact: Boolean = false,
    val isFinished: Boolean = false,
    val correctCount: Int = 0
) {
    val currentQuestion: Question? get() = questions.getOrNull(currentIndex)
    val progress: Float get() = if (questions.isEmpty()) 0f
    else (currentIndex + 1).toFloat() / questions.size
    val isAnswered: Boolean get() = selectedAnswerIndex != null
}

/**
 * ViewModel responsible for managing the Quiz logic and state.
 * Demonstrates Architecture Components and Lifecycle awareness.
 */
class QuizViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(QuizUiState())
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()

    private var timerJob: Job? = null

    /**
     * Cancels any active timers when the ViewModel is destroyed.
     */
    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }

    /**
     * Initializes a new quiz session with the selected category and difficulty.
     */
    fun startQuiz(
        category: Category,
        difficulty: Difficulty,
        timerEnabled: Boolean,
        showFunFacts: Boolean
    ) {
        val questions = QuestionRepository
            .getByCategoryAndDifficulty(category, difficulty)
            .shuffled()
            .take(10)

        _uiState.value = QuizUiState(
            questions = questions,
            timerEnabled = timerEnabled,
            showFunFact = false
        )

        if (timerEnabled) startTimer()
    }

    /**
     * Processes the user's answer selection and updates the score.
     * Points are calculated based on time remaining if the timer is enabled.
     */
    fun selectAnswer(index: Int) {
        val state = _uiState.value
        if (state.isAnswered) return

        timerJob?.cancel()

        val correct = state.currentQuestion?.correctAnswerIndex == index
        val points  = if (correct) {
            if (state.timerEnabled) 10 + state.timeLeft else 10
        } else 0

        _uiState.value = state.copy(
            selectedAnswerIndex = index,
            score = state.score + points,
            showFunFact = true,
            correctCount = if (correct) state.correctCount + 1 else state.correctCount
        )
    }

    /**
     * Transitions to the next question or finishes the quiz if at the end.
     */
    fun nextQuestion() {
        val state = _uiState.value
        val nextIndex = state.currentIndex + 1

        if (nextIndex >= state.questions.size) {
            _uiState.value = state.copy(isFinished = true)
            return
        }

        _uiState.value = state.copy(
            currentIndex = nextIndex,
            selectedAnswerIndex = null,
            timeLeft = 15,
            showFunFact = false
        )

        if (state.timerEnabled) startTimer()
    }

    /**
     * Coroutine-based timer that counts down from 15 seconds.
     */
    private fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (_uiState.value.timeLeft > 0) {
                delay(1000L)
                val s = _uiState.value
                if (s.isAnswered) break
                if (s.timeLeft <= 1) {
                    // Time's up — auto select wrong
                    _uiState.value = s.copy(
                        timeLeft = 0,
                        selectedAnswerIndex = -1,
                        showFunFact = true
                    )
                    break
                }
                _uiState.value = s.copy(timeLeft = s.timeLeft - 1)
            }
        }
    }
}
