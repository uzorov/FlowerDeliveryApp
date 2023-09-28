package com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guru.composecookbook.meditation.ui.spacerHeight10
import com.guru.composecookbook.meditation.ui.spacerHeight20
import com.ilukhina.uylia.flowerdeliveryapp.R
import com.ilukhina.uylia.flowerdeliveryapp.ui.MainViewModel
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.components.FlowerCard
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.FlowerProvider

@Composable
fun MainScreen(viewModel: MainViewModel) {
    //Экран с букетами
    MainScreenContent(viewModel)
}

@Composable
fun MainScreenContent(viewModel: MainViewModel) {


    //Можно загрузить из базы данных
        val flowerItemsForFirstSection = remember {
            mutableStateOf(FlowerProvider.flowerItems.take(5))
        }


    //Можно загрузить из базы данных
    val flowerItemsForSecondSection = remember {
        mutableStateOf(FlowerProvider.flowerItems.takeLast(5))
    }

        Box(modifier = Modifier.fillMaxSize()) {

            LazyColumn(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
            ) {
                item {
                    AppTitleSection()
                    spacerHeight10()
                    DiscoverFlowersSection()
                    spacerHeight20()
                    TheFirstFlowerSection(viewModel)
                    spacerHeight20()
                    TheSecondFlowerSection(viewModel)
                }
            }
        }
    }

@Composable
fun AppTitleSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 15.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    )
    {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Icon",
            modifier = Modifier.size(100.dp)
        )
    }
}

@Composable
fun DiscoverFlowersSection() {
    Column(
        modifier = Modifier.padding(horizontal = 15.dp)
    ) {
        Text(
            text = "Исследуйте новое",
            style = MaterialTheme.typography.h1,
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp
        )
        Text(
            text = "Найдите букет, который поднимет Вам настроение",
            style = MaterialTheme.typography.body1,
            color = Gray,
            fontSize = 18.sp
        )
    }
}

@Composable
fun TheFirstFlowerSection(viewModel: MainViewModel) {
    val context = LocalContext.current
    val flowers = viewModel.getFlowersList().take(5)

    Column {
        Text(
            modifier = Modifier.padding(start = 15.dp),
            text = "Осеннее настроение",
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        spacerHeight10()
        LazyRow(
            contentPadding = PaddingValues(horizontal = 7.dp),
        ) {
            items(flowers.size) {
                FlowerCard(
                    flowerItem = flowers[it], Modifier
                        .padding(end = 7.5.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Green.copy(0.1F))
                        .wrapContentHeight()
                        .wrapContentWidth()
                        .clickable {
                            viewModel.addBucketItem(flowers[it])
                            Toast
                                .makeText(context, "Букет добавлен в корзину", Toast.LENGTH_SHORT)
                                .show()
                            Log.d("TEST",viewModel.getBucketList().toString())
                        }
                )
            }
        }
    }
}

@Composable
fun TheSecondFlowerSection(viewModel: MainViewModel) {
    val context = LocalContext.current
    val flowers = viewModel.getFlowersList().takeLast(5)

    Column {
        Text(
            modifier = Modifier.padding(start = 15.dp),
            text = "Найдите тот самый букет",
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        spacerHeight10()
        LazyRow(
            contentPadding = PaddingValues(horizontal = 7.dp),
        ) {
            items(flowers.size) {
                FlowerCard(
                    flowerItem = flowers[it], Modifier
                        .padding(end = 7.5.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Yellow.copy(0.1F))
                        .wrapContentHeight()
                        .wrapContentWidth()
                        .clickable {
                            viewModel.addBucketItem(flowers[it])
                            Toast
                                .makeText(context, "Букет добавлен в корзину", Toast.LENGTH_SHORT)
                                .show()
                        }
                )
            }
        }
    }
}






