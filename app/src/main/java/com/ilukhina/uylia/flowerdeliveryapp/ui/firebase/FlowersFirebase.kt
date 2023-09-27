package com.ilukhina.uylia.flowerdeliveryapp.ui.firebase

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FlowersFirebase {
    private lateinit var database: DatabaseReference

    fun initializeDbRefFlowers() {
        database = FirebaseDatabase.getInstance().getReference("Flowers")

    }

    fun getFlowerFromDB(flowerName: String) {
        database.child(flowerName).get().addOnSuccessListener {
            Log.d("TAG", "Item: $flowerName Successfully loaded")
        }.addOnFailureListener{
            Log.d("TAG", "Item: $flowerName Failed to load")
        }
    }

}