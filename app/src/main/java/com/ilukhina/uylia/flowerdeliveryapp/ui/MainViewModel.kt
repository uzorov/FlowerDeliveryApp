package com.ilukhina.uylia.flowerdeliveryapp.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.FlowerItem
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.OrderItem
import com.ilukhina.uylia.flowerdeliveryapp.ui.firebase.OrderFirebase

class MainViewModel : ViewModel() {

    private val flowerListMutableStateData = SnapshotStateList<FlowerItem>()


    private val orderListLiveData = MutableLiveData<List<OrderItem>>()
    private val orderList = sortedSetOf<OrderItem>({ p0, p1 -> p0.orderId.compareTo(p1.orderId) })
    private val order = OrderFirebase()

    private var orderCost: Float = 0.0f



    fun addFlowerItem(flowerItem: FlowerItem) {
        flowerListMutableStateData.add(flowerItem)
        orderCost+=flowerItem.price.toInt()
    }

    fun getFlowerList(): SnapshotStateList<FlowerItem> {
        return flowerListMutableStateData
    }

    fun deleteFlowerItem(flowerItem: FlowerItem) {
        flowerListMutableStateData.remove(flowerItem)
        orderCost-=flowerItem.price.toInt()
    }

    fun getOrderCost(): MutableState<Float> {
        return mutableFloatStateOf(orderCost)
    }

    fun addOrderItem(orderItem: OrderItem, orderFirebase: OrderFirebase) {
        orderList.add(orderItem)
        orderFirebase.initializeDbRefOrders()
        orderFirebase.createNewOrder(orderItem)

        updateOrderList()
    }

    private fun updateOrderList() {
        orderListLiveData.value = orderList.toList()
    }

    fun getOrderList(): MutableState<List<OrderItem>> {
        return mutableStateOf(orderList.toList())
    }

    fun deleteOrderItem(orderItem: OrderItem) {
        orderList.remove(orderItem)
        updateOrderList()
    }

}