package com.ilukhina.uylia.flowerdeliveryapp.ui

import FlowerNames
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.FlowerItem
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.OrderItem
import com.ilukhina.uylia.flowerdeliveryapp.ui.firebase.FlowersFirebase
import com.ilukhina.uylia.flowerdeliveryapp.ui.firebase.OrderFirebase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {



    private var flowerListMutableStateData = SnapshotStateList<FlowerItem>()

    private val bucketListMutableStateData = SnapshotStateList<FlowerItem>()


    private var flowerFb : FlowersFirebase = FlowersFirebase()

    private val getFlowers: (FlowerItem?) -> Unit = { flower ->
        addFlowersItem(flower)
    }


    private val orderListLiveData = MutableLiveData<List<OrderItem>>()
    private val orderList = sortedSetOf<OrderItem>({ p0, p1 -> p0.orderId.compareTo(p1.orderId) })
    private val orderFb = OrderFirebase()

    private var orderCost: Float = 0.0f

    init {

        Log.d("DatabaseError", "Trying to launch loadFlowers()")
        viewModelScope.launch {
            loadFlowers()
        }
        Log.d("DatabaseError", "Successfully launched loadFlowers()")
    }

    private fun loadFlowers() {
        Log.d("DatabaseError", "Trying to launch loadFlowers() 2")
        flowerFb.initializeDbRefFlowers()
        Log.d("DatabaseError", "Trying to launch loadFlowers() 3")
        val flowerNames = FlowerNames.flowerNames
        Log.d("DatabaseError", "Trying to launch loadFlowers() 4")
        flowerFb.getAllFlowerFromDB(flowerNames, getFlowers)

    }

    private fun addFlowersItem(flowerItem: FlowerItem?) {
        Log.d("TAG", flowerItem.toString())
        if (flowerItem != null) {
            flowerListMutableStateData.add(flowerItem)
        }
    }


    fun getFlowersList(): SnapshotStateList<FlowerItem> {
        return flowerListMutableStateData
    }

    fun addBucketItem(flowerItem: FlowerItem) {
        bucketListMutableStateData.add(flowerItem)
        orderCost += flowerItem.price.toInt()

    }

    fun getBucketList(): SnapshotStateList<FlowerItem> {
        return bucketListMutableStateData
    }

    fun deleteFlowerItem(flowerItem: FlowerItem) {
        bucketListMutableStateData.remove(flowerItem)
        orderCost -= flowerItem.price.toInt()
    }

    fun getOrderCost(): String {
        var orderCost = 0;
        bucketListMutableStateData.forEach { it ->
            orderCost += it.price.toInt()
        }
        return orderCost.toString()
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