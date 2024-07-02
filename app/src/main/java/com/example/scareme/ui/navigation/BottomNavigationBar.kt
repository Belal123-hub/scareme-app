package com.example.scareme.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.scareme.R

@Composable
fun BottomNavigationBar(
    currentRoute: NavigationItem?,
    onNavigate: (NavigationItem) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1E001E))
            .padding(16.dp)
            .paddingFromBaseline(bottom = 0.dp), // Adjusts position to bottom
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val isHomeSelected = currentRoute == NavigationItem.Home
        val isChatSelected = currentRoute == NavigationItem.ChatList
        val isProfileSelected = currentRoute == NavigationItem.ProfileInfo

        if (isHomeSelected) {
            ItemSelected(
                icon = R.drawable.ic_home_selected,
                onNavigate = { onNavigate.invoke(NavigationItem.Home) }
            )
        } else {
            ItemUnselected(
                icon = R.drawable.ic_home_unselected,
                onNavigate = { onNavigate.invoke(NavigationItem.Home) }
            )
        }

       if (isChatSelected){
           ItemSelected(
            onNavigate = { onNavigate.invoke(NavigationItem.ChatList) },
            icon = R.drawable.ic_chat_selected,
        )
      }
        else{
           ItemUnselected(
               onNavigate = { onNavigate.invoke(NavigationItem.ChatList) },
               icon = R.drawable.ic_chat_unselected,
           )
        }

        if (isProfileSelected){
            ItemSelected(
            onNavigate = { onNavigate.invoke(NavigationItem.ProfileInfo) },
            icon = R.drawable.ic_profile_selected,
        )
        }
        else{
            ItemUnselected(
                onNavigate = { onNavigate.invoke(NavigationItem.ProfileInfo) },
                icon = R.drawable.ic_profile_unselected,
            )
        }
    }
}

@Composable
fun ItemSelected(icon: Int, onNavigate: () -> Unit) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = Modifier
            .size(40.dp)
            .clickable { onNavigate.invoke() },
        tint = Color(0xFFB14623)
    )
}

@Composable
fun ItemUnselected(icon: Int, onNavigate: () -> Unit) {
    Box(
        modifier = Modifier.size(40.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(26.dp)
                .clickable { onNavigate.invoke() },
            tint = Color(0xFFB14623)
        )
    }
}