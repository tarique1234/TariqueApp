package com.example.demoapp.quizResult

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class QuizResultViewModelFactory(private val finalScore: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(QuizResultViewModel::class.java)){
            return QuizResultViewModel(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
