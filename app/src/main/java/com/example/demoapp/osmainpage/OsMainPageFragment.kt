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
import com.example.demoapp.databinding.FragmentOsMainPageBinding

class OsMainPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentOsMainPageBinding>(inflater, R.layout.fragment_os_main_page, container, false)
        binding.quizButton.setOnClickListener { view: View -> view.findNavController().navigate(R.id.action_osMainPageFragment_to_osQuizPageFragment) }
        binding.notesButton.setOnClickListener{ val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/operating-systems/"))
            startActivity(intent)}
        (activity as AppCompatActivity).supportActionBar?.title = "Operating System"
        return binding.root
    }

}