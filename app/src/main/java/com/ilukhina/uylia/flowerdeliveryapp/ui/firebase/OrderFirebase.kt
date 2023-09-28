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
                val flowerItemList = mutableListOf<FlowerItem>()
                Log.d("ORDERRRR",customerName.toString())
                Log.d("ORDERRRR",customerName.toString())
                Log.d("ORDERRRR",deliveryAddress.toString())
                Log.d("ORDERRRR",orderDate.toString())
                Log.d("ORDERRRR",orderPrice.toString())
                flowerItems.children.forEach { childSnapshot ->
                    // Извлеките значения полей из childSnapshot
                    val name = childSnapshot.child("name").value as String
                    val price = childSnapshot.child("price").value as String
                    val description = childSnapshot.child("description").value as String
                    val pictureUrl = childSnapshot.child("pictureUrl").value as String
                    val flowerItem = FlowerItem(name, price, description, pictureUrl)
                    flowerItemList.add(flowerItem)
                }
                Log.d("ORDERRRR",flowerItemList.toString())
                order = OrderItem(
                    orderId = (orderId?.toString())!!.toInt(),
                    customerName?.toString() ?: "",
                    deliveryAddress?.toString() ?: "",
                    flowerItemList,
                    orderDate.toString(),
                    orderPrice = (orderPrice?.toString())!!.toInt()
                )
                Log.d("ORDERRRR", "2"+order.toString())
                callback(order)
            }
            Log.d("TAG", "Order: $orderID Successfully loaded")
        }.addOnFailureListener{
            Log.d("TAG", "Order: $orderID Failed to load")
        }
    }
}