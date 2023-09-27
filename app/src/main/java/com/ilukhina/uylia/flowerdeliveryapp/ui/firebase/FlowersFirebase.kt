package com.ilukhina.uylia.flowerdeliveryapp.ui.firebase

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.FlowerItem

class FlowersFirebase {
    private lateinit var database: DatabaseReference
    private var flower: FlowerItem ?= null
    fun initializeDbRefFlowers() {
        database = FirebaseDatabase.getInstance().getReference("Flowers")
    }

    fun getFlowerFromDB(flowerName: String, callback: (FlowerItem?) -> Unit) {
        database.child(flowerName).get().addOnSuccessListener { snapshot ->
            if (snapshot.exists()) {
                val name = snapshot.child("name").value
                val price = snapshot.child("price").value
                val description = snapshot.child("description").value
                val pictureUrl = snapshot.child("pictureUrl").value
                val flower = FlowerItem(
                    name?.toString() ?: "",
                    price?.toString() ?: "",
                    description?.toString() ?: "",
                    pictureUrl?.toString() ?: ""
                )
                Log.d("TAG", "Item: $flower Successfully loaded")
                callback(flower)
            } else {
                Log.d("TAG", "Item: $flowerName Not found")
                callback(null)
            }
        }.addOnFailureListener {
            Log.d("TAG", "Item: $flowerName Failed to load")
            callback(null)
        }
    }




}