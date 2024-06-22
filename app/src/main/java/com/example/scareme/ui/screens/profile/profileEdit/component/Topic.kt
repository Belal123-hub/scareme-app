package com.example.scareme.ui.screens.profile.profileEdit.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Topic(
    id: String,
    title: String,
    isSelected: Boolean,
    onTopicClick: (String) -> Unit
) {
    Box (
       modifier = Modifier
           .background(Color(0xFF180c14))
            .padding(horizontal = 4.dp, vertical = 4.dp)
           .border(BorderStroke(2.dp, Color(0xFFFF7F27)), shape = RoundedCornerShape(18.dp))
   ){
    Text(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) Color(0xFF1E001E) else Color(0xFFFFA500))
            .clickable { onTopicClick.invoke(id) },
        text = title,
        color = if (isSelected)  Color(0xFFFFA500) else Color.Black,
    )
}
}