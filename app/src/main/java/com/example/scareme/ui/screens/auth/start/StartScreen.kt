package com.example.scareme.ui.screens.auth.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scareme.R
import com.example.scareme.ui.common.ScareMeButton
import com.example.scareme.ui.theme.ScareMeTheme

@Composable
fun StartScreen(){

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF130912)),
        contentAlignment = Alignment.Center

    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {


            Image(
                painter = painterResource(R.drawable.scareme),
                contentDescription = "null",
                modifier = Modifier
                    .size(250.dp)
                    .offset(70.dp, 200.dp),
                // contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.height(300.dp))

            ScareMeButton("Sign Up")


            Text(
                text = "Already have an account?",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 130.dp),
                textAlign = TextAlign.Center,
                color = Color(0xFFB14623)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Sign In",
                modifier = Modifier.fillMaxWidth()
                // .padding(top = 140.dp)
                ,
                textAlign = TextAlign.Center,
                color = Color(0xFFF6921D)
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ScareMeTheme {
        StartScreen()
    }
}