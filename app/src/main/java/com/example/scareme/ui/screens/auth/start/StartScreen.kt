package com.example.scareme.ui.screens.auth.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scareme.R
import com.example.scareme.ui.common.ScareMeButton
import com.example.scareme.ui.theme.ScareMeTheme

@Composable
fun StartScreen(
    onStartClick: () -> Unit,
    onSignUpClick: () -> Unit,

){

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF130912)),
        contentAlignment = Alignment.Center

    ) {
        var enabled by rememberSaveable{ mutableStateOf(true)}

        ImageLayout()

        Column(
            modifier = Modifier.padding(16.dp)
        ) {


            Image(
                painter = painterResource(R.drawable.scareme),
                contentDescription = stringResource(R.string.scareMe),
                modifier = Modifier
                    .size(250.dp)
                    .offset(70.dp, 200.dp),
                // contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.height(300.dp))

            ScareMeButton(stringResource(R.string.to_sign_up),onSignUpClick)


            Text(
                text = stringResource(R.string.already_have_an_account),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                textAlign = TextAlign.Center,
                color = Color(0xFFB14623),
                fontFamily = FontFamily(Font(R.font.baloopaaaji))
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(R.string.to_sign_in),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(enabled = enabled) {
                        enabled = false
                        onStartClick()
                    }
                // .padding(top = 140.dp)
                ,
                textAlign = TextAlign.Center,
                color = Color(0xFFF6921D)
            )

        }
    }
}

@Composable
fun ImageLayout() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ellipse_20),
                    contentDescription = "Image 1",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(4.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ellipse_18),
                    contentDescription = "Image 2",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(4.dp)
                )
            }
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ellipse_16),
                        contentDescription = "Image 1",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ellipse_17),
                        contentDescription = "Image 2",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(4.dp)
                    )
                }
            }
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ellipse_15),
                        contentDescription = "Image 1",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(4.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ellipse_14),
                        contentDescription = "Image 2",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(4.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ScareMeTheme {
        StartScreen(onStartClick = {}, onSignUpClick = {})
    }
}