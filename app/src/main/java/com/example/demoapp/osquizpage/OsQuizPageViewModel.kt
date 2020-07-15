package com.example.demoapp.osquizpage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OsQuizPageViewModel: ViewModel() {

    data class Question(val text: String, val answers: List<String>)

    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "Which of the following requires a device driver?",
            answers = listOf("Disk", "Main Memory", "Cache", "Register")),
        Question(text = "Which of the following command we should use to delete files on Linux System?",
            answers = listOf("Rm", "Delete", "Mv", "Expunge")),
        Question(text = "Which of the following is a valid permission in the Linux File System?",
            answers = listOf("Write", "Full Control", "Modify", "Change")),
        Question(text = "In what mode can only one program be executed at a time?",
            answers = listOf("Real", "Virtual Real", "Compatibility", "Protected")),
        Question(text = "A common boundary between two computer Systems in known as: ",
            answers = listOf("Interface", "Intraface", "Surface", "None of the above")),
        Question(text = "What is a program in execution called?",
            answers = listOf("Process", "Paging", "Thread", "Demand Page")),
        Question(text = "Copying a process from memory to disk to allow space for other processes is called:",
            answers = listOf("Swapping", "Deadlock", "Demand Paging", "page fault")),
        Question(text = "First-In-First-Out (FIFO) scheduling is",
            answers = listOf("Non Preemptive Scheduling", "Preemptive Scheduling", "File Share Scheduling", "Deadline Scheduling")),
        Question(text = "The mechanism of bringing a page into memory only when it is needed is knwon as:",
            answers = listOf("Demand Paging", "Dormant Paging", "Page Fault", "Deadlock")),
        Question(text = "Which of the following memory unit that processor can access more rapidly",
            answers = listOf("Cache Memory", "Main Memory", "Virtual Memory", "All of the above"))
    )

    val currentQuestion = MutableLiveData<Question>()
    val answer = MutableLiveData<MutableList<String>>()
    val questionIndex = MutableLiveData<Int>()
    val correctAnswer = MutableLiveData<Int>()

    init{
        questionIndex.value = 0
        correctAnswer.value = 0
        randomizeQuestions()
    }

    fun randomizeQuestions() {
        questions.shuffle()
        setQuestion()
    }

    fun setQuestion() {
        currentQuestion.value = questions[questionIndex.value!!]
        // randomize the answers into a copy of the array
        answer.value = currentQuestion!!.value!!.answers.toMutableList()
        // and shuffle them
        answer!!.value!!.shuffle()

    }


}