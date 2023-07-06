package com.example.englishwords

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WordsViewModel(val tur:Int, val translation:Boolean, val level:Int):ViewModel() {

    private val _wordList = MutableLiveData<List<Translation>>()
    val wordList : LiveData<List<Translation>> get() = _wordList

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
        viewModelScope.launch {
            _wordList.value = FirebaseProfileService.getA1Word()
        }
    }

    fun getA2Word(){
        viewModelScope.launch {
            _wordList.value = FirebaseProfileService.getA2Word()
        }
    }

    fun getB1Word(){
        viewModelScope.launch {
            _wordList.value = FirebaseProfileService.getB1Word()
        }
    }

    fun getB2Word(){
        viewModelScope.launch {
            _wordList.value = FirebaseProfileService.getB2Word()
        }
    }

    fun getA1Phrase(){
        viewModelScope.launch {
            _wordList.value = FirebaseProfileService.getA1Phrase()
        }
    }

    fun getA2Phrase(){
        viewModelScope.launch {
            _wordList.value = FirebaseProfileService.getA2Phrase()
        }
    }

    fun getB1Phrase(){
        viewModelScope.launch {
            _wordList.value = FirebaseProfileService.getB1Phrase()
        }
    }

    fun getB2Phrase(){
        viewModelScope.launch {
            _wordList.value = FirebaseProfileService.getB2Phrase()
        }
    }

    fun listShuffle(list:ArrayList<Translation>):ArrayList<Translation>{
        list.shuffle()
        return list
    }


}