package com.ilukhina.uylia.flowerdeliveryapp.ui.firebase

import android.util.Log
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.FlowerItem

class ReadWriteData {
    private lateinit var database: DatabaseReference

    fun initializeDbRef() {
        database = FirebaseDatabase.getInstance().getReference("Flowers")

    }

    fun createNewFlower(flowerItem: FlowerItem) {
        val flower = flowerItem
        database.child(flower.flowerId.toString()).setValue(flower).addOnSuccessListener {
            Log.d("TAG","Item: $flower")
        }.addOnFailureListener {
            Toast.makeText(null, "Failed", Toast.LENGTH_SHORT).show()
        }

    }

}