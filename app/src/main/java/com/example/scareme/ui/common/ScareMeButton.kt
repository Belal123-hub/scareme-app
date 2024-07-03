package com.example.scareme.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scareme.R

@Composable
fun ScareMeButton(name:String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
        ,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFA500)
        ),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(text = name, fontSize = 18.sp, color = Color.Black,fontFamily = FontFamily(
            Font(R.font.baloopaaaji))
        )
    }
}