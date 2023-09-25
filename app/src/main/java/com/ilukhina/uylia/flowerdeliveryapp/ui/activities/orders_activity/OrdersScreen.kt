package com.ilukhina.uylia.flowerdeliveryapp.ui.activities.orders_activity

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.ilukhina.uylia.flowerdeliveryapp.ui.MainViewModel
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.FlowerProvider
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.OrderProvider

@Composable
fun OrdersScreen(viewModel: MainViewModel) {
    val orderItems = remember {
        mutableStateOf(OrderProvider.orderItems)
    }
    Text(text = orderItems.toString())
}