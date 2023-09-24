package com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.BottomNavItem

object BottomNavItemProvider {
    val bottomNavItems : List<BottomNavItem> = listOf(
        BottomNavItem(
            "Букеты",
            RoutesProvider.ROUTE_TO_THE_MAIN_SCREEN,
            Icons.Default.Home,
            0
        ),
        BottomNavItem(
            "Корзина",
            RoutesProvider.ROUTE_TO_THE_SHOPPING_CART_SCREEN,
            Icons.Default.ShoppingCart,
            0
        ),
        BottomNavItem(
            "Мои заказы",
            RoutesProvider.ROUTE_TO_THE_ORDERS_SCREEN,
            Icons.Default.Info,
            0
        )
    )
}