package com.example.demoapp.mainpage

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.demoapp.R
import com.example.demoapp.databinding.FragmentMainpageBinding

class mainpageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMainpageBinding>(inflater, R.layout.fragment_mainpage, container, false)
        binding.quizButton.setOnClickListener { view: View -> view.findNavController().navigate(R.id.action_mainpageFragment_to_quizPageFragment) }
        binding.notesButton.setOnClickListener{ val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/dbms/"))
                                                startActivity(intent)}
        (activity as AppCompatActivity).supportActionBar?.title = "DataBase System"
        return binding.root
    }

}