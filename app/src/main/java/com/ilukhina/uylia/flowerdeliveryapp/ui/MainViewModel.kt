package com.ilukhina.uylia.flowerdeliveryapp.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.ktx.Firebase
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.FlowerItem
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.OrderItem
import com.ilukhina.uylia.flowerdeliveryapp.ui.firebase.FlowersFirebase
import com.ilukhina.uylia.flowerdeliveryapp.ui.firebase.OrderFirebase
import java.util.TreeSet

class MainViewModel : ViewModel() {

    private val flowerListMutableStateData = SnapshotStateList<FlowerItem>()

    private val bucketListLiveData = MutableLiveData<List<FlowerItem>>()
    private val bucketList = sortedSetOf<FlowerItem>({ p0, p1 -> p0.name.compareTo(p1.name) })

    private val flowerListLiveData = MutableLiveData<List<FlowerItem>>()
    private val flowerList = sortedSetOf<FlowerItem>({ p0, p1 -> p0.name.compareTo(p1.name) })
    private val flowerFb = FlowersFirebase()

    private val getFlowers: (FlowerItem?) -> Unit = { flower ->
        addFlowersItem(flower)
        Log.d("TAG","Callback1 $flower")
        if (flower != null) {
            flowerList.add(flower)
        }
        Log.d("TAG","Callback2 $flowerList")
    }


    private val orderListLiveData = MutableLiveData<List<OrderItem>>()
    private val orderList = sortedSetOf<OrderItem>({ p0, p1 -> p0.orderId.compareTo(p1.orderId) })
    private val orderFb = OrderFirebase()

    private var orderCost: Float = 0.0f

    fun loadFlowers() {
        flowerFb.initializeDbRefFlowers()
        val flowerNames = FlowerNames.flowerNames
        flowerFb.getFlowerFromDB(flowerNames.get(1),getFlowers)
        Log.d("TAG",flowerList.toString())
    }

    fun addFlowersItem(flowerItem: FlowerItem?) {
        Log.d("TAG", flowerItem.toString())
        if (flowerItem != null) {
            flowerList.add(flowerItem)
        }
        updateFlowersList()
    }

    private fun updateFlowersList() {
        flowerListLiveData.value = bucketList.toList()
    }

    fun getFlowersList(): MutableState<List<FlowerItem>> {
        return mutableStateOf(flowerList.toList())
    }

    fun addBucketItem(flowerItem: FlowerItem) {
        bucketList.add(flowerItem)
        orderCost += flowerItem.price.toInt()
        updateBucketList()
    }

    private fun updateBucketList() {
        bucketListLiveData.value = bucketList.toList()
    }

    fun getBucketList(): SnapshotStateList<List<FlowerItem>> {
        return bucketList.toList()
    }

    fun deleteFlowerItem(flowerItem: FlowerItem) {
        bucketList.remove(flowerItem)
        orderCost -= flowerItem.price.toInt()
        updateBucketList()
    }

    fun getOrderCost(): MutableState<Float> {
        return bucketListLiveData
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