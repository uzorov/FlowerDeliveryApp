package com.ilukhina.uylia.flowerdeliveryapp.ui.activities.cart_activity.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.FlowerItem

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CartItem(flowerItem: FlowerItem, modifier: Modifier) {

    BoxWithConstraints(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxSize()
                .padding(horizontal = 16.dp),

            ) {


            GlideImage(
                model = flowerItem.pictureUrl,
                contentDescription = "Flower",
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .padding(8.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center

            )


            Text(
                text = flowerItem.name,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 5.dp)

            )
            Text(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                text = flowerItem.description,
                color = Color.Black.copy(0.9f),
                style = MaterialTheme.typography.body1,
                fontSize = 10.sp
            )
            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                text = "Цена: " + flowerItem.price,
                color = Color.Black.copy(0.9f),
                style = MaterialTheme.typography.body1,
                fontSize = 10.sp
            )

        }
    }
}