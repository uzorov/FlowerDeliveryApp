package com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.Navigation
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.components.BottomNavigationBar
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.BottomNavItemProvider
import com.ilukhina.uylia.flowerdeliveryapp.ui.theme.FlowerDeliveryAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowerDeliveryAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val navHostController = rememberNavController()

    var isHomeButtonPressed by remember { mutableStateOf(true) }
    var isShoppingCartButtonPressed by remember { mutableStateOf(false) }
    var isOrdersButtonPressed by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(title = {Text(text = "Доставка цветов")})
        },
        bottomBar = {
            BottomNavigationBar(items = BottomNavItemProvider.bottomNavItems,
                navController = navHostController,
                OnItemClick = {
                    //Навигация по экранам
                    navHostController.navigate(it.route)
                })
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Navigation(navController = navHostController)
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}