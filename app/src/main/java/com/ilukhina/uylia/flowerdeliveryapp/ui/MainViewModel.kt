package com.ilukhina.uylia.flowerdeliveryapp.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.FlowerItem
import java.util.TreeSet

class MainViewModel: ViewModel() {

    private val flowerListLiveData = MutableLiveData<List<FlowerItem>>()
    private val flowerList= sortedSetOf<FlowerItem>({ p0, p1 -> p0.name.compareTo(p1.name) })
     fun addFlowerItem(flowerItem: FlowerItem) {
        flowerList.add(flowerItem)
        updateList()
    }

    private fun updateList(){
        flowerListLiveData.value = flowerList.toList()
    }

    fun getList(): MutableState<List<FlowerItem>> {
        return mutableStateOf(flowerList.toList())
    }

    fun deleteFlowerItem(flowerItem: FlowerItem) {
        flowerList.remove(flowerItem)
        updateList()
    }

}