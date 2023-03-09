package com.example.englishwords

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.englishwords.databinding.FragmentLevelBinding
import com.google.firebase.firestore.FirebaseFirestore

class LevelFragment : Fragment() {
    private lateinit var binding:FragmentLevelBinding
    private val args:LevelFragmentArgs by navArgs()
    private var translation = 0
    private lateinit var list : ArrayList<Translation>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLevelBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.a1Button.setOnClickListener(){
            if(binding.toggleButton.isChecked){
                translation = 1
            }
            it.findNavController().navigate(LevelFragmentDirections.actionLevelFragmentToWordsFragment(args.tur,translation,1))
        }
        binding.a2Button.setOnClickListener(){
            if(binding.toggleButton.isChecked){
                translation = 1
            }
            it.findNavController().navigate(LevelFragmentDirections.actionLevelFragmentToWordsFragment(args.tur,translation,2))
        }
        binding.b1Button.setOnClickListener(){
            if(binding.toggleButton.isChecked){
                translation = 1
            }
            it.findNavController().navigate(LevelFragmentDirections.actionLevelFragmentToWordsFragment(args.tur,translation,3))
        }
        binding.b2Button.setOnClickListener(){
            if(binding.toggleButton.isChecked){
                translation = 1
            }
            it.findNavController().navigate(LevelFragmentDirections.actionLevelFragmentToWordsFragment(args.tur,translation,4))
        }
    }
}