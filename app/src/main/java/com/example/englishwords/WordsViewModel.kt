package com.example.englishwords

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WordsViewModel(val repository: TranslationRepository,val tur:Int, val translation:Int, val level:Int):ViewModel() {

    private val _wordList = MutableLiveData<UIState<ArrayList<Translation>>>()
    val wordList : LiveData<UIState<ArrayList<Translation>>> get() = _wordList

    init {
        when(tur){
            1 -> {
                when(level){
                    1 -> getA1Word()
                    2 -> getA2Word()
                    3 -> getB1Word()
                    4 -> getB2Word()
                }
            }

            2 -> {
                when(level){
                    1 -> getA1Phrase()
                    2 -> getA2Phrase()
                    3 -> getB1Phrase()
                    4 -> getB2Phrase()
                }
            }
        }
    }

    fun getA1Word(){
        _wordList.value = UIState.Loading
        repository.getA1Word {_wordList.value = it }
    }

    fun getA2Word(){
        _wordList.value = UIState.Loading
        repository.getA2Word { _wordList.value = it }
    }

    fun getB1Word(){
        _wordList.value = UIState.Loading
        repository.getB1Word { _wordList.value = it }
    }

    fun getB2Word(){
        _wordList.value = UIState.Loading
        repository.getB2Word { _wordList.value = it }
    }

    fun getA1Phrase(){
        _wordList.value = UIState.Loading
        repository.getA1Phrase { _wordList.value = it }
    }

    fun getA2Phrase(){
        _wordList.value = UIState.Loading
        repository.getA2Phrase { _wordList.value = it }
    }

    fun getB1Phrase(){
        _wordList.value = UIState.Loading
        repository.getB1Phrase { _wordList.value = it }
    }

    fun getB2Phrase(){
        _wordList.value = UIState.Loading
        repository.getB2Phrase { _wordList.value = it }
    }

}