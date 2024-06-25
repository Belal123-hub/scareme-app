package com.example.scareme.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.scareme.R
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment


@Composable
fun BottomNavigationBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .paddingFromBaseline(bottom = 0.dp), // Adjusts position to bottom
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavItem(
            navController = navController,
            icon = R.drawable.group_2,
            route = NavigationItem.Home.route,
        )
        BottomNavItem(
            navController = navController,
            icon = R.drawable.group_4,
            route = NavigationItem.ChatList.route
        )
        BottomNavItem(
            navController = navController,
            icon = R.drawable.group_3,
            route = NavigationItem.ProfileInfo.route
        )
    }
}



@Composable
fun BottomNavItem(navController: NavController, icon: Int, route: String) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = Modifier
            .size(40.dp)
            .clickable { navController.navigate(route) },
        tint = Color(0xFFB14623)
    )
}
