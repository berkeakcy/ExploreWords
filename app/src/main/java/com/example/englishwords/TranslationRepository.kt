package com.example.englishwords

interface TranslationRepository {
    fun getA1Word(result : (UIState<ArrayList<Translation>>) -> Unit)
    fun getA2Word(result : (UIState<ArrayList<Translation>>) -> Unit)
    fun getB1Word(result : (UIState<ArrayList<Translation>>) -> Unit)
    fun getB2Word(result : (UIState<ArrayList<Translation>>) -> Unit)
    fun getA1Phrase(result : (UIState<ArrayList<Translation>>) -> Unit)
    fun getA2Phrase(result : (UIState<ArrayList<Translation>>) -> Unit)
    fun getB1Phrase(result : (UIState<ArrayList<Translation>>) -> Unit)
    fun getB2Phrase(result : (UIState<ArrayList<Translation>>) -> Unit)
}