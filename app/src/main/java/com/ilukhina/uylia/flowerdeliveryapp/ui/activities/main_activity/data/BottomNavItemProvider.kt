package com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart

object BottomNavItemProvider {
    val bottomNavItems : List<BottomNavItem> = listOf(
        BottomNavItem(
            "Продукты",
            "home",
            Icons.Default.ShoppingCart,
            0
        ),
        BottomNavItem(
            "Рецепты",
            "recipes",
            Icons.Default.Search,
            0
        ),
        BottomNavItem(
            "Избранное",
            "favorite",
            Icons.Default.FavoriteBorder,
            0
        ),
        BottomNavItem(
            "Профиль",
            "profile",
            Icons.Default.Person,
            0
        )
    )
}