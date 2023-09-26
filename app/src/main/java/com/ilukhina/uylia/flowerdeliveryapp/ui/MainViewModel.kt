package com.ilukhina.uylia.flowerdeliveryapp.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.FlowerItem
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.OrderItem
import com.ilukhina.uylia.flowerdeliveryapp.ui.firebase.ReadWriteData
import java.util.TreeSet

class MainViewModel : ViewModel() {

    private val flowerListLiveData = MutableLiveData<List<FlowerItem>>()
    private val flowerList = sortedSetOf<FlowerItem>({ p0, p1 -> p0.name.compareTo(p1.name) })

    private val orderListLiveData = MutableLiveData<List<OrderItem>>()
    private val orderList = sortedSetOf<OrderItem>({ p0, p1 -> p0.orderId.compareTo(p1.orderId) })

    private val postFlower = ReadWriteData()

    fun initPostFlower(postFlower: ReadWriteData, flowerItem: FlowerItem) {
        postFlower.initializeDbRef()
        postFlower.createNewFlower(flowerItem)
    }

    fun addFlowerItem(flowerItem: FlowerItem) {
        initPostFlower(postFlower, flowerItem)
        flowerList.add(flowerItem)
        updateFlowerList()
    }

    private fun updateFlowerList() {
        flowerListLiveData.value = flowerList.toList()
    }

    fun getFlowerList(): MutableState<List<FlowerItem>> {
        return mutableStateOf(flowerList.toList())
    }

    fun deleteFlowerItem(flowerItem: FlowerItem) {
        flowerList.remove(flowerItem)
        updateFlowerList()
    }

    fun addOrderItem(orderItem: OrderItem) {
        orderList.add(orderItem)
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