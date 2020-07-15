package com.example.demoapp.osquizresult

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
import com.example.demoapp.databinding.FragmentOsQuizResultBinding

class OsQuizResultFragment : Fragment() {

    private lateinit var viewModel: OsQuizResultViewModel
    private lateinit var viewModelFactory: OsQuizResultViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentOsQuizResultBinding>(inflater, R.layout.fragment_os_quiz_result, container, false)

        viewModelFactory = OsQuizResultViewModelFactory(OsQuizResultFragmentArgs.fromBundle(arguments!!).score)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(OsQuizResultViewModel::class.java)

        binding.scoreText.text = viewModel.score.value.toString()

        binding.playAgainButton.setOnClickListener { view :View -> view.findNavController().navigate(R.id.action_osQuizResultFragment_to_osQuizPageFragment) }
        binding.homeButton.setOnClickListener { view: View -> view.findNavController().navigate(R.id.action_osQuizResultFragment_to_osMainPageFragment) }
        //return inflate.inflate(R.layout.fragment_quiz_result, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "Operating System Quiz"
        return binding.root
    }


}