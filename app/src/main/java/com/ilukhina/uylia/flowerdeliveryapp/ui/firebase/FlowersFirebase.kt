package com.ilukhina.uylia.flowerdeliveryapp.ui.firebase

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.FlowerItem

class FlowersFirebase {
    private lateinit var database: DatabaseReference
    private lateinit var flower: FlowerItem

    fun initializeDbRefFlowers() {
        database = FirebaseDatabase.getInstance().getReference("Flowers")

    }

    fun getFlowerFromDB(flowerName: String): FlowerItem {
        database.child(flowerName).get().addOnSuccessListener {
            if(it.exists()) {
                val name = it.child("name").value
                val price = it.child("price").value
                val description = it.child("description").value
                val pictureUrl = it.child("pictureUrl").value
                flower = FlowerItem(name.toString(), price.toString(), description.toString(), pictureUrl.toString())
            }
            Log.d("TAG", "Item: $flowerName Successfully loaded")
        }.addOnFailureListener{
            Log.d("TAG", "Item: $flowerName Failed to load")
        }
        return flower
    }
}