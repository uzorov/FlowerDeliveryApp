package com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.BottomNavItem
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.FlowerItem

object FlowerProvider {
    val flowerItems : List<FlowerItem> = listOf(
        FlowerItem(
            name = "Радуга",
            price = "1100",
            description = "Букет “Радуга” - это воплощение яркости и красоты. Он состоит из разноцветных роз, лилий, гербер и ирисов. Этот букет подарит радость и веселье, поднимая настроение своими яркими оттенками и ароматами",
            pictureUrl = "https://mykaleidoscope.ru/uploads/posts/2021-10/1635290317_64-mykaleidoscope-ru-p-dizainerskie-buketi-tsvetov-tsveti-69.jpg"
        ),
        FlowerItem(
            name = "Весеннее настроение",
            price = "3200",
            description = "Букет “Весеннее настроение” - это настоящая весна в каждом цветке. Он состоит из нарциссов, тюльпанов, пионов и фиалок. Этот букет пробуждает чувство свежести и новых начинаний, наполняя пространство нежными ароматами.",
            pictureUrl = "https://mykaleidoscope.ru/uploads/posts/2021-10/1635293699_43-mykaleidoscope-ru-p-buketi-super-tsveti-47.jpg"
        ),
        FlowerItem(
            name = "Летнее солнце",
            price = "1000",
            description = "Букет “Летнее солнце” - это яркое сияние лета в каждом цветке. Он состоит из подсолнухов, гладиолусов, хризантем и лаванды. Этот букет наполняет комнату теплом и энергией, создавая атмосферу праздника.",
            pictureUrl = "https://wdorogu.ru/images/wp-content/uploads/beautiful-flower-bouquets-51.jpg"
        ),
        FlowerItem(
            name = "Осенний бриз",
            price = "3100",
            description = "Букет “Осенний бриз” - это теплое приветствие осени в каждом цветке. Он состоит из астр, декабристов, хризантем и эустомы. Этот букет приносит ощущение уюта и спокойствия, перенося нас в мир осенних красок и ароматов.",
            pictureUrl = "https://mykaleidoscope.ru/uploads/posts/2020-08/1596477982_53-p-shikarnie-buketi-lilii-pinterest-76.jpg"
        ),
        FlowerItem(
            name = "Зимнее волшебство",
            price = "5200",
            description = "Букет “Зимнее волшебство” - это сказочная зима в каждом цветке. Он состоит из белых и красных роз, эустомы и амариллис. Этот букет создает атмосферу праздника и загадочности, наполняя пространство ароматами зимы.",
            pictureUrl = "https://mykaleidoscope.ru/uploads/posts/2022-06/1656054407_25-mykaleidoscope-ru-p-krasivii-buket-krasnikh-roz-krasivo-foto-26.jpg"
        ),
        FlowerItem(
            name = "",
            price = "",
            description = "",
            pictureUrl = "https://mykaleidoscope.ru/uploads/posts/2022-06/1656041290_40-mykaleidoscope-ru-p-krasivie-vesennie-buketi-krasivo-foto-40.jpg"
        ),
        FlowerItem(
            name = "",
            price = "",
            description = "",
            pictureUrl = "https://static.tildacdn.com/tild6630-3034-4233-a436-636637633665/360835-svetik.jpg"
        ),
        FlowerItem(
            name = "",
            price = "",
            description = "",
            pictureUrl = "http://vsegda-pomnim.com/uploads/posts/2022-04/1650517541_146-vsegda-pomnim-com-p-krasivii-buket-tsvetov-foto-156.jpg"
        ),
        FlowerItem(
            name = "",
            price = "",
            description = "",
            pictureUrl = "https://mykaleidoscope.ru/uploads/posts/2022-06/1656345337_37-mykaleidoscope-ru-p-tsvetnie-rozi-buket-krasivo-foto-41.jpg"
        ),
        FlowerItem(
            name = "",
            price = "",
            description = "",
            pictureUrl = "https://mykaleidoscope.ru/uploads/posts/2022-06/1656033358_33-mykaleidoscope-ru-p-buket-iz-raznikh-tsvetov-krasivo-foto-36.jpg"
        )
    )
}