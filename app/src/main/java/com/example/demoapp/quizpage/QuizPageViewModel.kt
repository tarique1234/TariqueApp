package com.example.demoapp.quizpage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuizPageViewModel: ViewModel() {

    data class Question(val text: String, val answers: List<String>)

    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "In a relational model, relations are termed as:",
            answers = listOf("Tables", "Tuple", "Attributes", "Rows")),
        Question(text = "The database Schema is written in: ",
            answers = listOf("DDL", "DML", "DCL", "HLL")),
        Question(text = "What do we call an entity set that does not have sufficient attributes to form a primary key?",
            answers = listOf("Weak entity set", "Strong entity set", "Simple entity set", "None of the above")),
        Question(text = "How are attributes represented in E-R diagram?",
            answers = listOf("Ellipse", "Rectangle", "Square", "Triangle")),
        Question(text = "What does a sub-schema expresses?",
            answers = listOf("External View", "Physical View", "Logical View", "All the above")),
        Question(text = "Which symbol is used to represent a weak entity set in E-R diagram?",
            answers = listOf("Doubly outlined rectangle", "Diamond", "Dotted Rectangle", "None of the above.")),
        Question(text = "________ produces relation that has attributes of both the relation.",
            answers = listOf("Cartesian Product", "Difference", "Intersection", "Product")),
        Question(text = "Which of the following is a valid SQL type?",
            answers = listOf("All of the above", "CHARACTER", "NUMERIC", "FLOAT")),
        Question(text = "What is the full form of DDL?",
            answers = listOf("Data Definition Language", "Data Derivation Language", "Detailed Data Language", "Dynamic Data Language")),
        Question(text = "What is the set of possible data values called?",
            answers = listOf("Domain", "Attribute", "Degree", "Tuple"))
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