package com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model

data class OrderItem(
    val orderId: Int,
    val customerName: String,
    val deliveryAddress: String,
    val flowerItems: List<FlowerItem>,
    val orderDate: String
)

