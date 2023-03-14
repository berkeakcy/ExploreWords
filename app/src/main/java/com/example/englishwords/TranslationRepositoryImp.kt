package com.example.englishwords

import android.util.Log
import com.example.englishwords.Translation.Companion.toTranslation
import com.google.firebase.firestore.FirebaseFirestore

class TranslationRepositoryImp:TranslationRepository {
    private lateinit var database : FirebaseFirestore

    override fun getA1Word(result: (UIState<ArrayList<Translation>>) -> Unit) {
        val data = arrayListOf<Translation>()
        database = FirebaseFirestore.getInstance()
        database.collection("English").document("Word").collection("A1").get().addOnSuccessListener {
            for(document in it){
                val word = document.toTranslation()
                data.add(word!!)
            }
            result.invoke(
                UIState.Success(data)
            )
        }.addOnFailureListener{
            result.invoke(
                UIState.Failure(it.localizedMessage)
            )
        }
    }

    override fun getA2Word(result: (UIState<ArrayList<Translation>>) -> Unit) {
        val data = arrayListOf<Translation>()
        database = FirebaseFirestore.getInstance()
        database.collection("English").document("Word").collection("A2").get().addOnSuccessListener {
            for(document in it){
                val word = document.toTranslation()
                data.add(word!!)
            }
            result.invoke(
                UIState.Success(data)
            )
        }.addOnFailureListener{
            result.invoke(
                UIState.Failure(it.localizedMessage)
            )
        }
    }

    override fun getB1Word(result: (UIState<ArrayList<Translation>>) -> Unit) {
        val data = arrayListOf<Translation>()
        database = FirebaseFirestore.getInstance()
        database.collection("English").document("Word").collection("B1").get().addOnSuccessListener {
            for(document in it){
                val word = document.toTranslation()
                data.add(word!!)
            }
            result.invoke(
                UIState.Success(data)
            )
        }.addOnFailureListener{
            result.invoke(
                UIState.Failure(it.localizedMessage)
            )
        }
    }

    override fun getB2Word(result: (UIState<ArrayList<Translation>>) -> Unit) {
        val data = arrayListOf<Translation>()
        database = FirebaseFirestore.getInstance()
        database.collection("English").document("Word").collection("B2").get().addOnSuccessListener {
            for(document in it){
                val word = document.toTranslation()
                data.add(word!!)
            }
            result.invoke(
                UIState.Success(data)
            )
        }.addOnFailureListener{
            result.invoke(
                UIState.Failure(it.localizedMessage)
            )
        }
    }

    override fun getA1Phrase(result: (UIState<ArrayList<Translation>>) -> Unit) {
        val data = arrayListOf<Translation>()
        database = FirebaseFirestore.getInstance()
        database.collection("English").document("Phrase").collection("A1").get().addOnSuccessListener {
            for(document in it){
                val word = document.toTranslation()
                data.add(word!!)
            }
            result.invoke(
                UIState.Success(data)
            )
        }.addOnFailureListener{
            result.invoke(
                UIState.Failure(it.localizedMessage)
            )
        }
    }

    override fun getA2Phrase(result: (UIState<ArrayList<Translation>>) -> Unit) {
        val data = arrayListOf<Translation>()
        database = FirebaseFirestore.getInstance()
        database.collection("English").document("Phrase").collection("A2").get().addOnSuccessListener {
            for(document in it){
                val word = document.toTranslation()
                data.add(word!!)
            }
            result.invoke(
                UIState.Success(data)
            )
        }.addOnFailureListener{
            result.invoke(
                UIState.Failure(it.localizedMessage)
            )
        }
    }

    override fun getB1Phrase(result: (UIState<ArrayList<Translation>>) -> Unit) {
        val data = arrayListOf<Translation>()
        database = FirebaseFirestore.getInstance()
        database.collection("English").document("Phrase").collection("B1").get().addOnSuccessListener {
            for(document in it){
                val word = document.toTranslation()
                data.add(word!!)
            }
            result.invoke(
                UIState.Success(data)
            )
        }.addOnFailureListener{
            result.invoke(
                UIState.Failure(it.localizedMessage)
            )
        }
    }

    override fun getB2Phrase(result: (UIState<ArrayList<Translation>>) -> Unit) {
        val data = arrayListOf<Translation>()
        database = FirebaseFirestore.getInstance()
        database.collection("English").document("Phrase").collection("B2").get().addOnSuccessListener {
            for(document in it){
                val word = document.toTranslation()
                data.add(word!!)
            }
            result.invoke(
                UIState.Success(data)
            )
        }.addOnFailureListener{
            result.invoke(
                UIState.Failure(it.localizedMessage)
            )
        }
    }
}