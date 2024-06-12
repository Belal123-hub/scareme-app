package com.example.scareme.ui.screens.signIn


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.scareme.ui.screens.common.ScareMeButton


@Composable
fun SignInScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E001E)),
        contentAlignment = Alignment.Center
    ) {
        Column(
           // horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(104.dp))

            Text(
                text = "Sign In",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(5.dp))
            InputField(label = "E-mail")
            Spacer(modifier = Modifier.height(8.dp))
            InputField(label = "Password")

            Spacer(modifier = Modifier.height(300.dp))
           ScareMeButton("Sign In")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(label: String) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text(text = label, color = Color.White) },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF3A003A), shape = RoundedCornerShape(8.dp)),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
           // textColor = Color.White,
            cursorColor = Color.White,
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.White
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignInScreen()
}