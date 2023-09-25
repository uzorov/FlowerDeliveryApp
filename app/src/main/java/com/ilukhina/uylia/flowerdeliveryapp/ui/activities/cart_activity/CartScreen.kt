package com.ilukhina.uylia.flowerdeliveryapp.ui.activities.cart_activity

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guru.composecookbook.meditation.ui.spacerHeight10
import com.ilukhina.uylia.flowerdeliveryapp.ui.MainViewModel
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.components.FlowerCard
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.FlowerItem

@Composable
fun CartScreen(viewModel: MainViewModel) {
    BasketSection(flowerItems = viewModel.getFlowerList(), viewModel = viewModel)
}

@Composable
fun BasketSection(flowerItems: MutableState<List<FlowerItem>>, viewModel: MainViewModel) {
    val context = LocalContext.current

    Column {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 7.dp),
        ) {
            items(flowerItems.value.size) {
                FlowerCard(
                    flowerItem = flowerItems.value[it], Modifier
                        .padding(end = 7.5.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Green.copy(0.1F))
                        .wrapContentHeight()
                        .wrapContentWidth()
                        .clickable {
                            viewModel.deleteFlowerItem(flowerItems.value[it])
                            Toast
                                .makeText(context, "Букет удален из корзины", Toast.LENGTH_SHORT)
                                .show()
                            Log.d("TEST",
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


