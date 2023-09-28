package com.ilukhina.uylia.flowerdeliveryapp.ui.activities.orders_activity

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ilukhina.uylia.flowerdeliveryapp.ui.MainViewModel
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.OrderProvider
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.OrderItem
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.orders_activity.components.OrderCard

@Composable
fun OrdersScreen(viewModel: MainViewModel) {
    OrdersContent(viewModel.getOrderList())
}

@Composable
fun OrdersContent(orderItems: MutableState<List<OrderItem>>) {
    LazyColumn() {
        items(orderItems.value.size) {
            OrderCard(
                orderItems.value[it],
                Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Gray.copy(0.9F))
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .clickable {}
            )
        }
    }
}