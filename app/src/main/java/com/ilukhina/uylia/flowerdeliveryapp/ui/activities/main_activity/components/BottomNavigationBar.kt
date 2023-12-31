package com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ilukhina.uylia.flowerdeliveryapp.ui.activities.main_activity.data.model.BottomNavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    OnItemClick: (BottomNavItem) -> Unit,
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier
            .border(width = 1.dp, color = Color.LightGray.copy(0.4F))
            .heightIn(80.dp, 100.dp),
        backgroundColor = Color.White,

        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { OnItemClick(item) },
                selectedContentColor = Color.Black.copy(1F),
                unselectedContentColor = Color.Gray.copy(0.3f),
                alwaysShowLabel = false,
                label = { Text(
                    text = item.name,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp
                )},
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            Badge(
                                content = {
                                    Text(text = item.badgeCount.toString())
                                }
                            )
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name,
                                modifier = Modifier.size(32.dp)
                            )


                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name,
                                modifier = Modifier.size(32.dp)

                            )
                        }
                    }
                })
        }
    }
}