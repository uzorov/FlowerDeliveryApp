package com.ilukhina.uylia.flowerdeliveryapp.ui

import android.annotation.SuppressLint
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.Navigation
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.components.BottomNavigationBar
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.BottomNavItemProvider
import com.ilukhina.uylia.flowerdeliveryapp.ui.theme.FlowerDeliveryAppTheme


class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContent {
            FlowerDeliveryAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(viewModel)
                }
            }
        }
    }
}


@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {

    val navHostController = rememberNavController()

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
            Navigation(navController = navHostController,viewModel)
        }
    }
}

