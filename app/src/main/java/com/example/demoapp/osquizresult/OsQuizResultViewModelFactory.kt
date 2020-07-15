package com.example.demoapp.osquizresult

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class OsQuizResultViewModelFactory(private val finalScore: Int): ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(OsQuizResultViewModel::class.java)){
            return OsQuizResultViewModel(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}