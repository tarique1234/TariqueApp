package com.example.demoapp.osquizpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.demoapp.R
import com.example.demoapp.databinding.FragmentOsQuizpageBinding

class OsQuizPageFragment: Fragment() {

    private lateinit var viewModel: OsQuizPageViewModel

    private val numQuestions = 3


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        //creating the binding variable
        val binding = DataBindingUtil.inflate<FragmentOsQuizpageBinding>(inflater, R.layout.fragment_os_quizpage, container, false)

        //Associating the view Model
        viewModel = ViewModelProviders.of(this).get(OsQuizPageViewModel::class.java)

        //Binding the current Fragment class with the layout
        binding.quizViewModel = viewModel


        //setting the onClickListener() for the nextButton
        binding.submitButton.setOnClickListener { _ : View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }

                //If the given answer is correct
                if (viewModel.answer.value!![answerIndex] == viewModel.currentQuestion.value!!.answers[0]) {
                    viewModel.correctAnswer.value = (viewModel.correctAnswer.value)?.plus(1)
                }
                viewModel.questionIndex.value = (viewModel.questionIndex.value)?.plus(1)
                // Advance to the next question
                val tempQuestionIndex: Int = (viewModel.questionIndex.value)!!
                if (tempQuestionIndex < numQuestions) {
                    setTitle(tempQuestionIndex+1)
                    viewModel.setQuestion()
                    binding.invalidateAll()
                } else {
                    completeQuiz()
                }
            }
        }

        //Setting the action Listener for the skip Button.
        binding.skipButton.setOnClickListener { _ : View ->
            viewModel.questionIndex.value = (viewModel.questionIndex.value)?.plus(1)
            // Advance to the next question
            val tempQuestionIndex: Int = (viewModel.questionIndex.value)!!
            if (tempQuestionIndex < numQuestions) {
                setTitle(tempQuestionIndex+1)
                viewModel.setQuestion()
                binding.invalidateAll()
            } else {
                // All Questions complete.
                completeQuiz()
            }
        }
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.os_quiz, viewModel.questionIndex.value!!.plus(1), numQuestions)
        return binding.root
    }

    private fun completeQuiz(){
        val action = OsQuizPageFragmentDirections.actionOsQuizPageFragmentToOsQuizResultFragment()
        action.score = viewModel.correctAnswer.value?:0
        NavHostFragment.findNavController(this).navigate(action)
    }

    private fun setTitle(tempIndex: Int){
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.os_quiz, tempIndex, numQuestions)
    }

}