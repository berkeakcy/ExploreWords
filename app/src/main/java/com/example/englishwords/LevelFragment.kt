package com.example.englishwords

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.englishwords.databinding.FragmentLevelBinding


class LevelFragment : Fragment() {
    private lateinit var binding:FragmentLevelBinding
    private val args:LevelFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLevelBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.a1Button.setOnClickListener() {
            if (binding.toggleButton.isChecked) {
                it.findNavController().navigate(
                    LevelFragmentDirections.actionLevelFragmentToWordsFragment(
                        false,
                        1,
                        args.tur
                    )
                )
            } else {
                it.findNavController().navigate(
                    LevelFragmentDirections.actionLevelFragmentToWordsFragment(
                        true,
                        1,
                        args.tur
                    )
                )
            }
        }
        binding.a2Button.setOnClickListener(){
            if (binding.toggleButton.isChecked) {
                it.findNavController().navigate(
                    LevelFragmentDirections.actionLevelFragmentToWordsFragment(
                        false,
                        2,
                        args.tur
                    )
                )
            } else {
                it.findNavController().navigate(
                    LevelFragmentDirections.actionLevelFragmentToWordsFragment(
                        true,
                        2,
                        args.tur
                    )
                )
            }
        }
        binding.b1Button.setOnClickListener(){
            if (binding.toggleButton.isChecked) {
                it.findNavController().navigate(
                    LevelFragmentDirections.actionLevelFragmentToWordsFragment(
                        false,
                        3,
                        args.tur
                    )
                )
            } else {
                it.findNavController().navigate(
                    LevelFragmentDirections.actionLevelFragmentToWordsFragment(
                        true,
                        3,
                        args.tur
                    )
                )
            }
        }
        binding.b2Button.setOnClickListener(){
            if (binding.toggleButton.isChecked) {
                it.findNavController().navigate(
                    LevelFragmentDirections.actionLevelFragmentToWordsFragment(
                        false,
                        4,
                        args.tur
                    )
                )
            } else {
                it.findNavController().navigate(
                    LevelFragmentDirections.actionLevelFragmentToWordsFragment(
                        true,
                        4,
                        args.tur
                    )
                )
            }
        }
    }
}