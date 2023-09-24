package com.ilukhina.uylia.flowerdeliveryapp.ui.activities

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.cart_activity.CartScreen
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.MainScreen
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.RoutesProvider
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.orders_activity.OrdersScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = RoutesProvider.ROUTE_TO_THE_MAIN_SCREEN
    ) {

        composable(RoutesProvider.ROUTE_TO_THE_MAIN_SCREEN) {
            MainScreen()
        }
        composable(RoutesProvider.ROUTE_TO_THE_SHOPPING_CART_SCREEN) {
            CartScreen()
        }
        composable(RoutesProvider.ROUTE_TO_THE_ORDERS_SCREEN) {
            OrdersScreen()
        }


    }
}