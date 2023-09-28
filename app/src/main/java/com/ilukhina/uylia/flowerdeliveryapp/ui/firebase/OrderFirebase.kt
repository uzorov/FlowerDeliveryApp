package com.ilukhina.uylia.flowerdeliveryapp.ui.firebase

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.getValue
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.FlowerItem
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.OrderItem

class OrderFirebase {
    private lateinit var database: DatabaseReference
    private var order: OrderItem ?= null

    fun initializeDbRefOrders() {
        database = FirebaseDatabase.getInstance().getReference("Orders")
    }

    fun createNewOrder(OrderItem: OrderItem) {
        val order = OrderItem
        database.child(order.orderId.toString()).setValue(order).addOnSuccessListener {
            Log.d("TAG","Order: $order Successfully crested")
        }.addOnFailureListener {
            Log.d("TAG", "Order : $order Failed to create")
        }
    }

    fun getOrderFromDB(orderID: Int, callback: (OrderItem?) -> Unit) {
        database.child(orderID.toString()).get().addOnSuccessListener {snapshot ->
            if(snapshot.exists()) {
                val orderId = snapshot.child("orderId").value
                val customerName = snapshot.child("customerName").value
                val deliveryAddress = snapshot.child("deliveryAddress").value
                val flowerItems = snapshot.child("flowerItems")
                val orderDate = snapshot.child("orderDate").value
                val orderPrice = snapshot.child("orderPrice").value
                var flowerItem = mutableListOf<FlowerItem>()
                flowerItems.getValue<List<FlowerItem>>()
                order = OrderItem(
                    orderId = (orderId ?: 0) as Int,
                    customerName?.toString() ?: "",
                    deliveryAddress?.toString() ?: "",
                    flowerItems.getValue<List<FlowerItem>>() ?: listOf(),
                    orderDate.toString(),
                    orderPrice = (orderPrice ?: 0) as Int
                )
                callback(order)
            }
            Log.d("TAG", "Order: $orderID Successfully loaded")
        }.addOnFailureListener{
            Log.d("TAG", "Order: $orderID Failed to load")
        }
    }
}