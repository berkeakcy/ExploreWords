package com.example.englishwords

import android.util.Log
import com.example.englishwords.Translation.Companion.toTranslation
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.lang.Exception


object FirebaseProfileService {
    private const val TAG = "FirebaseProfileService"

    suspend fun getA1Word():List<Translation> {
        val db = FirebaseFirestore.getInstance()
        return try{
            db.collection("English").document("Word").collection("A1").get().await().documents.mapNotNull { it.toTranslation() }
        }
        catch (e:Exception){
            Log.e(TAG,"Error getting words",e)
            emptyList()
        }
    }

    suspend fun getA2Word():List<Translation> {
        val db = FirebaseFirestore.getInstance()
        return try{
            db.collection("English").document("Word").collection("A2").get().await().documents.mapNotNull { it.toTranslation() }
        }
        catch (e:Exception){
            Log.e(TAG,"Error getting words",e)
            emptyList()
        }
    }

    suspend fun getB1Word():List<Translation> {
        val db = FirebaseFirestore.getInstance()
        return try{
            db.collection("English").document("Word").collection("B1").get().await().documents.mapNotNull { it.toTranslation() }
        }
        catch (e:Exception){
            Log.e(TAG,"Error getting words",e)
            emptyList()
        }
    }

    suspend fun getB2Word():List<Translation> {
        val db = FirebaseFirestore.getInstance()
        return try{
            db.collection("English").document("Word").collection("B2").get().await().documents.mapNotNull { it.toTranslation() }
        }
        catch (e:Exception){
            Log.e(TAG,"Error getting words",e)
            emptyList()
        }
    }

    suspend fun getA1Phrase():List<Translation> {
        val db = FirebaseFirestore.getInstance()
        return try{
            db.collection("English").document("Phrase").collection("A1").get().await().documents.mapNotNull { it.toTranslation() }
        }
        catch (e:Exception){
            Log.e(TAG,"Error getting phrases",e)
            emptyList()
        }
    }

    suspend fun getA2Phrase():List<Translation> {
        val db = FirebaseFirestore.getInstance()
        return try{
            db.collection("English").document("Phrase").collection("A2").get().await().documents.mapNotNull { it.toTranslation() }
        }
        catch (e:Exception){
            Log.e(TAG,"Error getting phrases",e)
            emptyList()
        }
    }

    suspend fun getB1Phrase():List<Translation> {
        val db = FirebaseFirestore.getInstance()
        return try{
            db.collection("English").document("Phrase").collection("B1").get().await().documents.mapNotNull { it.toTranslation() }
        }
        catch (e:Exception){
            Log.e(TAG,"Error getting phrases",e)
            emptyList()
        }
    }

    suspend fun getB2Phrase():List<Translation> {
        val db = FirebaseFirestore.getInstance()
        return try{
            db.collection("English").document("Phrase").collection("B2").get().await().documents.mapNotNull { it.toTranslation() }
        }
        catch (e:Exception){
            Log.e(TAG,"Error getting phrases",e)
            emptyList()
        }
    }


}