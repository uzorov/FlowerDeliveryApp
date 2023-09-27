package com.ilukhina.uylia.flowerdeliveryapp.ui.activities.cart_activity

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ilukhina.uylia.flowerdeliveryapp.ui.MainViewModel
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.cart_activity.components.CartItem
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.OrderProvider
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.FlowerItem
import com.ilukhina.uylia.flowerdeliveryapp.ui.firebase.OrderFirebase

@Composable
fun CartScreen(viewModel: MainViewModel) {

    Scaffold(
        bottomBar = {
            PriceSection(viewModel = viewModel)
        },
        content = { innerPadding ->
            BasketSection(
                flowerItems = viewModel.getBucketList(),
                viewModel = viewModel,
                Modifier.padding(innerPadding)
            )
        }
    )


}

@Composable
fun PriceSection(sectionHeight: Dp = 150.dp,viewModel: MainViewModel) {
    val orderItems = remember {
        mutableStateOf(OrderProvider.orderItems)
    }
    val order = OrderFirebase()
    val context = LocalContext.current
    //Размеры экрана
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    val clientAddress = remember {
        mutableStateOf("")
    }

    val clientName = remember {
        mutableStateOf("")
    }

    Surface(
        color = Color.White,
        contentColor = Color.Black
    ) {
        Divider()
        Row(
            Modifier
                .fillMaxWidth()
                .height(sectionHeight)
                .selectableGroup()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        )
        {

            Column (modifier = Modifier.align(Alignment.Top).padding(vertical = 8.dp), verticalArrangement = Arrangement.Top ) {

                Text("Сумма заказа: ${viewModel.getOrderCost().value.toString()}")

                OutlinedTextField(
                    modifier = Modifier.width(screenWidth / 2 + 16.dp),
                    value = clientAddress.value,
                    onValueChange = { it -> clientAddress.value = it },
                    label = {
                        Text(
                            text = "Адрес"
                        )
                    })

                OutlinedTextField(
                    modifier = Modifier.width(screenWidth / 2 + 16.dp),
                    value = clientName.value,
                    onValueChange = { it -> clientName.value = it },
                    label = {
                        Text(
                            text = "Имя получателя"
                        )
                    })
            }
            Button(onClick = {
                viewModel.addOrderItem(orderItems.value[1],order)
                Toast
                    .makeText(context, "Заказ оформлен", Toast.LENGTH_SHORT)
                    .show()
                             }, modifier = Modifier.align(Alignment.Bottom)
                .padding(bottom = 8.dp, start = 16.dp)
                )
            {
                Text(text = "Оформить заказ", color = Color.White)
            }
        }
    }
}

@Composable
fun BasketSection(
    flowerItems: SnapshotStateList<FlowerItem>,
    viewModel: MainViewModel,
    padding: Modifier
) {
    val context = LocalContext.current

    Column(modifier = padding) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 7.dp),
        ) {
            items(flowerItems.size) {
                CartItem(
                    flowerItem = flowerItems[it], Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Blue.copy(0.1F))
                        .wrapContentWidth()
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            viewModel.deleteFlowerItem(flowerItems[it])
                            Toast
                                .makeText(context, "Букет удален из корзины", Toast.LENGTH_SHORT)
                                .show()
                            Log.d(
                                "TEST",
                                viewModel
                                    .getBucketList()
                                    .toString()
                            )
                        }
                )
            }
        }
    }
}


