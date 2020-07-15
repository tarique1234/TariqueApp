package com.example.demoapp.osquizresult

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OsQuizResultViewModel(finalScore: Int): ViewModel() {

    val score = MutableLiveData<Int>()
    init {
        score.value = finalScore
    }
}