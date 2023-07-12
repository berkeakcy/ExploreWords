package com.example.englishwords

import com.google.firebase.firestore.DocumentSnapshot

data class Translation(
    var eng : String?,
    var tr : String?
):java.io.Serializable {

    companion object{
        fun DocumentSnapshot.toTranslation():Translation?{
            val eng = getString("eng")
            val tr = getString("tr")
            return Translation(eng,tr)
        }
    }

}