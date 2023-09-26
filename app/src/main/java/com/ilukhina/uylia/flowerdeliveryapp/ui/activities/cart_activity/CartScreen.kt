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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ilukhina.uylia.flowerdeliveryapp.ui.MainViewModel
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.cart_activity.components.CartItem
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.FlowerItem

@Composable
fun CartScreen(viewModel: MainViewModel) {

    Scaffold(
        bottomBar = {
            PriceSection()
        },
        content = { innerPadding ->
            BasketSection(
                flowerItems = viewModel.getFlowerList(),
                viewModel = viewModel,
                Modifier.padding(innerPadding)
            )
        }
    )


}

@Composable
fun PriceSection(sectionHeight: Dp = 70.dp) {
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
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text("Сумма заказа")
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Оформить заказ", color = Color.White)
            }
        }
    }
}

@Composable
fun BasketSection(
    flowerItems: MutableState<List<FlowerItem>>,
    viewModel: MainViewModel,
    padding: Modifier
) {
    val context = LocalContext.current

    Column (modifier = padding) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 7.dp),
        ) {
            items(flowerItems.value.size) {
                CartItem(
                    flowerItem = flowerItems.value[it], Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Blue.copy(0.1F))
                        .wrapContentWidth()
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            viewModel.deleteFlowerItem(flowerItems.value[it])
                            Toast
                                .makeText(context, "Букет удален из корзины", Toast.LENGTH_SHORT)
                                .show()
                            Log.d(
                                "TEST",
                                viewModel
                                    .getFlowerList()
                                    .toString()
                            )
                        }
                )
            }
        }
    }
}


