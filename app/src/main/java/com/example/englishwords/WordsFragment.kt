package com.example.englishwords

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.englishwords.databinding.FragmentWordsBinding
import kotlin.properties.Delegates

class WordsFragment : Fragment() {
    private lateinit var binding: FragmentWordsBinding
    private lateinit var wordsViewModel:WordsViewModel
    private val args:WordsFragmentArgs by navArgs()
    private var translationList = ArrayList<Translation>()
    private var rnd by Delegates.notNull<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWordsBinding.inflate(inflater)
        wordsViewModel = ViewModelProvider(this,WordViewModelFactory(args.tur,args.translation,args.level)).get(WordsViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (wordsViewModel.translation){
            fromEnglishToTurkish()
        }
        else{
            fromTurkishToEnglish()
        }
    }

    private fun fromEnglishToTurkish(){
        if(view != null){
            wordsViewModel.wordList.observe(viewLifecycleOwner){
                translationList = it as ArrayList<Translation>
                if(translationList.size>2){
                    translationList = wordsViewModel.listShuffle(translationList)
                    binding.answerTextView.text = translationList.get(0).eng
                    rnd = (0..2).random()
                    when(rnd) {
                        0 -> {
                            binding.answerOneButton.text = translationList.get(0).tr
                            binding.answerTwoButton.text = translationList.get(1).tr
                            binding.answerThreeButton.text = translationList.get(2).tr

                            binding.answerOneButton.setOnClickListener {
                                binding.answerOneButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerOneButton.setBackgroundColor(Color.WHITE)
                                    fromEnglishToTurkish()
                                }, 1500)
                            }
                            binding.answerTwoButton.setOnClickListener {
                                binding.answerTwoButton.setBackgroundColor(Color.RED)
                                binding.answerOneButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerTwoButton.setBackgroundColor(Color.WHITE)
                                    binding.answerOneButton.setBackgroundColor(Color.WHITE)
                                    fromEnglishToTurkish()
                                }, 1500)
                            }
                            binding.answerThreeButton.setOnClickListener {
                                binding.answerThreeButton.setBackgroundColor(Color.RED)
                                binding.answerOneButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerThreeButton.setBackgroundColor(Color.WHITE)
                                    binding.answerOneButton.setBackgroundColor(Color.WHITE)
                                    fromEnglishToTurkish()
                                }, 1500)
                            }
                        }

                        1 -> {
                            binding.answerOneButton.text = translationList.get(1).tr
                            binding.answerTwoButton.text = translationList.get(0).tr
                            binding.answerThreeButton.text = translationList.get(2).tr

                            binding.answerOneButton.setOnClickListener {
                                binding.answerOneButton.setBackgroundColor(Color.RED)
                                binding.answerTwoButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerOneButton.setBackgroundColor(Color.WHITE)
                                    binding.answerTwoButton.setBackgroundColor(Color.WHITE)
                                    fromEnglishToTurkish()
                                }, 1500)
                            }
                            binding.answerTwoButton.setOnClickListener {
                                binding.answerTwoButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerTwoButton.setBackgroundColor(Color.WHITE)
                                    fromEnglishToTurkish()
                                }, 1500)
                            }
                            binding.answerThreeButton.setOnClickListener {
                                binding.answerThreeButton.setBackgroundColor(Color.RED)
                                binding.answerTwoButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerThreeButton.setBackgroundColor(Color.WHITE)
                                    binding.answerTwoButton.setBackgroundColor(Color.WHITE)
                                    fromEnglishToTurkish()
                                }, 1500)
                            }
                        }

                        2 -> {
                            binding.answerOneButton.text = translationList.get(2).tr
                            binding.answerTwoButton.text = translationList.get(1).tr
                            binding.answerThreeButton.text = translationList.get(0).tr

                            binding.answerOneButton.setOnClickListener {
                                binding.answerOneButton.setBackgroundColor(Color.RED)
                                binding.answerThreeButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerOneButton.setBackgroundColor(Color.WHITE)
                                    binding.answerThreeButton.setBackgroundColor(Color.WHITE)
                                    fromEnglishToTurkish()
                                }, 1500)
                            }
                            binding.answerTwoButton.setOnClickListener {
                                binding.answerTwoButton.setBackgroundColor(Color.RED)
                                binding.answerThreeButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerTwoButton.setBackgroundColor(Color.WHITE)
                                    binding.answerThreeButton.setBackgroundColor(Color.WHITE)
                                    fromEnglishToTurkish()
                                }, 1500)
                            }
                            binding.answerThreeButton.setOnClickListener {
                                binding.answerThreeButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerThreeButton.setBackgroundColor(Color.WHITE)
                                    fromEnglishToTurkish()
                                }, 1500)
                            }
                        }
                    }
                    translationList.removeAt(0)
                }
                else{
                    Toast.makeText(requireContext(),"Bu seviyedeki kelimeleri bitirdin. Bir üst seviyeye geçebilirsin",Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack()
                }
            }
        }
    }
    private fun fromTurkishToEnglish(){
        if(view != null){
            wordsViewModel.wordList.observe(viewLifecycleOwner){
                translationList = it as ArrayList<Translation>
                if(translationList.size>2){
                    translationList = wordsViewModel.listShuffle(translationList)
                    binding.answerTextView.text = translationList.get(0).tr
                    rnd = (0..2).random()
                    when(rnd) {
                        0 -> {
                            binding.answerOneButton.text = translationList.get(0).eng
                            binding.answerTwoButton.text = translationList.get(1).eng
                            binding.answerThreeButton.text = translationList.get(2).eng

                            binding.answerOneButton.setOnClickListener {
                                binding.answerOneButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerOneButton.setBackgroundColor(Color.WHITE)
                                    fromTurkishToEnglish()
                                }, 1500)
                            }
                            binding.answerTwoButton.setOnClickListener {
                                binding.answerTwoButton.setBackgroundColor(Color.RED)
                                binding.answerOneButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerTwoButton.setBackgroundColor(Color.WHITE)
                                    binding.answerOneButton.setBackgroundColor(Color.WHITE)
                                    fromTurkishToEnglish()
                                }, 1500)
                            }
                            binding.answerThreeButton.setOnClickListener {
                                binding.answerThreeButton.setBackgroundColor(Color.RED)
                                binding.answerOneButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerThreeButton.setBackgroundColor(Color.WHITE)
                                    binding.answerOneButton.setBackgroundColor(Color.WHITE)
                                    fromTurkishToEnglish()
                                }, 1500)
                            }
                        }

                        1 -> {
                            binding.answerOneButton.text = translationList.get(1).eng
                            binding.answerTwoButton.text = translationList.get(0).eng
                            binding.answerThreeButton.text = translationList.get(2).eng

                            binding.answerOneButton.setOnClickListener {
                                binding.answerOneButton.setBackgroundColor(Color.RED)
                                binding.answerTwoButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerOneButton.setBackgroundColor(Color.WHITE)
                                    binding.answerTwoButton.setBackgroundColor(Color.WHITE)
                                    fromTurkishToEnglish()
                                }, 1500)
                            }
                            binding.answerTwoButton.setOnClickListener {
                                binding.answerTwoButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerTwoButton.setBackgroundColor(Color.WHITE)
                                    fromTurkishToEnglish()
                                }, 1500)
                            }
                            binding.answerThreeButton.setOnClickListener {
                                binding.answerThreeButton.setBackgroundColor(Color.RED)
                                binding.answerTwoButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerThreeButton.setBackgroundColor(Color.WHITE)
                                    binding.answerTwoButton.setBackgroundColor(Color.WHITE)
                                    fromTurkishToEnglish()
                                }, 1500)
                            }
                        }

                        2 -> {
                            binding.answerOneButton.text = translationList.get(2).eng
                            binding.answerTwoButton.text = translationList.get(1).eng
                            binding.answerThreeButton.text = translationList.get(0).eng

                            binding.answerOneButton.setOnClickListener {
                                binding.answerOneButton.setBackgroundColor(Color.RED)
                                binding.answerThreeButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerOneButton.setBackgroundColor(Color.WHITE)
                                    binding.answerThreeButton.setBackgroundColor(Color.WHITE)
                                    fromTurkishToEnglish()
                                }, 1500)
                            }
                            binding.answerTwoButton.setOnClickListener {
                                binding.answerTwoButton.setBackgroundColor(Color.RED)
                                binding.answerThreeButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerTwoButton.setBackgroundColor(Color.WHITE)
                                    binding.answerThreeButton.setBackgroundColor(Color.WHITE)
                                    fromTurkishToEnglish()
                                }, 1500)
                            }
                            binding.answerThreeButton.setOnClickListener {
                                binding.answerThreeButton.setBackgroundColor(Color.GREEN)
                                Handler().postDelayed({
                                    binding.answerThreeButton.setBackgroundColor(Color.WHITE)
                                    fromTurkishToEnglish()
                                }, 1500)
                            }
                        }
                    }
                    translationList.removeAt(0)
                }
                else{
                    Toast.makeText(requireContext(),"Bu seviyedeki kelimeleri bitirdin. Bir üst seviyeye geçebilirsin",Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack()
                }
            }
        }
    }
}