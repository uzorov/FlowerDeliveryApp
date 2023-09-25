package com.ilukhina.uylia.flowerdeliveryapp.ui.firebase

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

    fun createNewFlower(flowerId: Int, name: String, price: String, description: String, pictureUrl:String) {
        val flower = FlowerItem(flowerId, name, price, description, pictureUrl)
        database.child(flowerId.toString()).setValue(flower).addOnSuccessListener {
            Toast.makeText(null, "Saved", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(null, "Failed", Toast.LENGTH_SHORT).show()
        }

    }

    fun readFromFlower()
}