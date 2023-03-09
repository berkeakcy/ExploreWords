package com.example.englishwords

interface TranslationRepository {
    fun getA1Word(result : (UIState<ArrayList<Translation>>) -> Unit)
}