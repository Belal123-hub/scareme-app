package com.example.scareme.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scareme.R

@Composable
fun MainScreen(){

    Box(
        modifier = Modifier
            .background(
                Color(0xFF1E001E),
                shape = RoundedCornerShape(4.dp)
            )
            .fillMaxSize()
    ){
        Box(){


            Image(
                painter = painterResource(
                    R.drawable.background),
                contentDescription = stringResource(R.string.background_upper_screen),
                modifier = Modifier
                    .fillMaxWidth()
                    .width(360.dp)
                    .height(344.dp)
            )
            Text(
                text = stringResource(R.string.trick_or_treat),
                modifier=Modifier.padding(start = 130.dp),
                textAlign = TextAlign.Center,
                color =Color.White,
                fontWeight = FontWeight.Bold,
                style = typography.titleLarge
            )
        }

        
    }

}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}