package com.example.englishwords

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.englishwords.Translation.Companion.toTranslation
import com.example.englishwords.databinding.FragmentHomeBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonKelimeler.setOnClickListener(){
            it.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLevelFragment(1))
        }
        binding.buttonKaliplar.setOnClickListener(){
            it.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLevelFragment(2))
        }
    }
}