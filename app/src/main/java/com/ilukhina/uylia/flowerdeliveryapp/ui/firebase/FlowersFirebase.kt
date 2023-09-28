package com.ilukhina.uylia.flowerdeliveryapp.ui.firebase

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.FlowerItem

class FlowersFirebase {
    private lateinit var database: DatabaseReference
    private var flower: FlowerItem ?= null
    fun initializeDbRefFlowers() {
        Log.d("DatabaseError", "Trying to init database")
        try {
            database = FirebaseDatabase.getInstance().getReference("Flowers")
        }
        catch (err: Error) {
            Log.d("DatabaseError", "Database init failed: $err")
        }
    }

    fun getAllFlowerFromDB(flowerNames: List<String>, callback: (FlowerItem?) -> Unit) {

        try {
            flowerNames.forEach {flowerName ->
                database.child(flowerName).get().addOnSuccessListener { snapshot ->
                    if (snapshot.exists()) {
                        val name = snapshot.child("name").value
                        val price = snapshot.child("price").value
                        val description = snapshot.child("description").value
                        val pictureUrl = snapshot.child("pictureUrl").value
                        flower = FlowerItem(
                            name?.toString() ?: "",
                            price?.toString() ?: "",
                            description?.toString() ?: "",
                            pictureUrl?.toString() ?: ""
                        )
                        Log.d("TAG", "Item: $flower Successfully loaded")
                        callback(flower)
                    } else {
                        Log.d("TAG", "Item: $flowerNames Not found")
                        callback(null)
                    }
                }.addOnFailureListener {
                    Log.d("TAG", "Item: $flowerNames Failed to load")
                    callback(null)
                }
            }
        }
        catch (err: Error)
        {
            Log.d("DatabaseError", err.toString())
        }
    }




}