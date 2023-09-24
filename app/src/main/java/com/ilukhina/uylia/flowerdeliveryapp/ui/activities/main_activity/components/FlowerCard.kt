package com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.components


import androidx.compose.foundation.layout.*
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
fun FlowerCard(flowerItem: FlowerItem, modifier: Modifier) {

    BoxWithConstraints(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .wrapContentHeight()
                .padding(horizontal = 8.dp)
                .height(250.dp)
                .fillMaxSize(),

            ) {


            GlideImage(
                model = flowerItem.pictureUrl,
                contentDescription = "Flower",
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .padding(4.dp),
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
                    .width(120.dp)
            )
            Text(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .width(120.dp),
                text = flowerItem.description,
                maxLines = 7,
                color = Color.Black.copy(0.9f),
                style = MaterialTheme.typography.body1,
                fontSize = 10.sp
            )

        }
    }
}