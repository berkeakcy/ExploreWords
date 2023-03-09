package com.example.englishwords

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.englishwords.databinding.FragmentSentencesBinding

class SentencesFragment : Fragment() {

    private lateinit var binding:FragmentSentencesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSentencesBinding.inflate(inflater)
        return binding.root
    }

}