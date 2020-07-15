package com.example.demoapp.quizResult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.demoapp.R
import com.example.demoapp.databinding.FragmentQuizResultBinding

class QuizResultFragment : Fragment() {

    private lateinit var viewModel: QuizResultViewModel
    private lateinit var viewModelFactory: QuizResultViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        
        val binding = DataBindingUtil.inflate<FragmentQuizResultBinding>(inflater, R.layout.fragment_quiz_result, container, false)

        viewModelFactory = QuizResultViewModelFactory(QuizResultFragmentArgs.fromBundle(arguments!!).score)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(QuizResultViewModel::class.java)

        binding.scoreText.text = viewModel.score.value.toString()

        binding.playAgainButton.setOnClickListener { view :View -> view.findNavController().navigate(R.id.action_quizResultFragment_to_quizPageFragment) }
        binding.homeButton.setOnClickListener { view: View -> view.findNavController().navigate(R.id.action_result_destination_to_mainpageFragment) }
        //return inflate.inflate(R.layout.fragment_quiz_result, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "Database System Quiz"
        return binding.root
    }

      
}