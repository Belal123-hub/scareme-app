package com.example.scareme.ui.screens.profile.profileEdit.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
    Text(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) Color.Gray else Color.Red)
            .clickable { onTopicClick.invoke(id) },
        text = title,
        color = if (isSelected) Color.Red else Color.Black,
    )
}