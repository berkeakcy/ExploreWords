package com.example.englishwords

import com.google.firebase.firestore.DocumentSnapshot

data class Translation(
    var eng : String,
    var tr : String
):java.io.Serializable {

    companion object{
        fun DocumentSnapshot.toTranslation():Translation?{
            val eng = get("eng") as String
            val tr = get("tr") as String
            return Translation(eng,tr)
        }
    }

}