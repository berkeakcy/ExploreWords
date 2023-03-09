package com.example.englishwords

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WordsViewModel(val repository: TranslationRepository,val tur:Int, val translation:Int, val level:Int):ViewModel() {

    private val _wordList = MutableLiveData<UIState<ArrayList<Translation>>>()
    val wordList : LiveData<UIState<ArrayList<Translation>>> get() = _wordList

    init {
        getWord()
    }

    fun getWord(){
        _wordList.value = UIState.Loading
        repository.getA1Word {_wordList.value = it }
    }

}