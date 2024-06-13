package com.example.scareme.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scareme.R
import com.example.scareme.ui.theme.ScareMeTheme

@Composable
fun LaunchScreen(){

    val listColors = listOf(
        Color(android.graphics.Color.rgb(19, 9, 18)),
        Color(android.graphics.Color.rgb(62, 28, 51))
    )

    Column (
        modifier=Modifier.fillMaxSize()
            .background( Brush.linearGradient(listColors))
    ){

        Image(
            painter = painterResource(R.drawable.group_5),
            contentDescription = "null",
            modifier=Modifier.offset(50.dp,150.dp)
                .width(277.dp)
                .height(250.dp),
           // contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(5.dp))

        Image(
            painter = painterResource(R.drawable.scareme),
            contentDescription = "null",
            modifier=Modifier.fillMaxSize(),
            // contentScale = ContentScale.FillBounds
        )

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScareMeTheme {
        LaunchScreen()
    }
}