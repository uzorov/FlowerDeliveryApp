package com.ilukhina.uylia.flowerdeliveryapp.ui.activities.orders_activity.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.OrderItem

@Composable
fun OrderCard(orderItem: OrderItem, modifier: Modifier) {

    BoxWithConstraints(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .wrapContentHeight()
                .padding(horizontal = 16.dp),

            ) {


            Text(
                text = "Номер заказа: " + orderItem.orderId,
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(vertical = 6.dp)

            )
            Text(
                text = orderItem.flowerItems.joinToString(prefix = "Состав заказа: ", separator = " ") { it.name },
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(vertical = 6.dp)

            )
            Text(
                text = "Получатель: " + orderItem.customerName,
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(vertical = 6.dp)

            )
            Text(
                text = "Адрес получателя: " + orderItem.deliveryAddress,
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(vertical = 6.dp)
            )

            Text(
                text = "Сумма заказа: " + orderItem.orderPrice,
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(vertical = 6.dp)
            )



        }
    }
}