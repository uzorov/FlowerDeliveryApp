package com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data

import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.FlowerItem
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.OrderItem

object OrderProvider {

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
        ))

    val orderItems:List<OrderItem> = listOf(
        OrderItem(1,"Ivan","dom2", flowerItems,"25.09.23"),
        OrderItem(2,"Ivan","dom2", flowerItems,"24.09.23")
    )
}