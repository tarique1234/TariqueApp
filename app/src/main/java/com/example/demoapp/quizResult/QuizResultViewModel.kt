package com.example.demoapp.quizResult

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuizResultViewModel(finalScore: Int): ViewModel() {

        val score = MutableLiveData<Int>()
        init {
            score.value = finalScore
        }

}