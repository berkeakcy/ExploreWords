package com.example.englishwords

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class WordViewModelFactory(
    private val tur:Int,
    private val translation:Boolean,
    private val level:Int
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(WordsViewModel::class.java!!)){
            WordsViewModel(this.tur,this.translation,this.level) as T
        } else{
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}