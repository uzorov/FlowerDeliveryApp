package com.ilukhina.uylia.flowerdeliveryapp.ui.firebase

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.OrderItem

class OrderFirebase {
    private lateinit var database: DatabaseReference

    fun initializeDbRefOrders() {
        database = FirebaseDatabase.getInstance().getReference("Orders")
    }

    //КИРИЛЛ ЛОХ
    fun createNewOrder(OrderItem: OrderItem) {
        val order = OrderItem
        database.child(order.orderId.toString()).setValue(order).addOnSuccessListener {
            Log.d("TAG","Order: $order Successfully crested")
        }.addOnFailureListener {
            Log.d("TAG", "Order : $order Failed to create")
        }
    }

    fun getOrderFromDB(orderID: Int) {
        database.child(orderID.toString()).get().addOnSuccessListener {
            Log.d("TAG", "Order: $orderID Successfully loaded")
        }.addOnFailureListener{
            Log.d("TAG", "Order: $orderID Failed to load")
        }
    }
}