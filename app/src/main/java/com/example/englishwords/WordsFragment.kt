package com.example.englishwords

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.englishwords.Translation.Companion.toTranslation
import com.example.englishwords.databinding.FragmentWordsBinding
import com.google.firebase.firestore.FirebaseFirestore

class WordsFragment : Fragment() {
    private lateinit var binding: FragmentWordsBinding
    private lateinit var wordsViewModel:WordsViewModel
    private val args:WordsFragmentArgs by navArgs()
    private var translationList = ArrayList<Translation>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWordsBinding.inflate(inflater)
        wordsViewModel = ViewModelProvider(this,WordViewModelFactory(TranslationRepositoryImp(),args.tur,args.translation,args.level)).get(WordsViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wordsViewModel.wordList.observe(viewLifecycleOwner){state ->
            translationList.clear()
            when(state){
                is UIState.Loading ->  Log.e("WordsFragment","Loading")
                is UIState.Failure ->  Log.e("WordsFragment","error")
                is UIState.Success -> {
                    state.data.forEach{
                        translationList.add(it)
                    }
                    Log.e("list ",translationList.toString())
                }
            }
        }
    }
}