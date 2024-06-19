package com.example.scareme.ui.screens.auth.signUp


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.scareme.R
import com.example.scareme.ui.common.ScareMeButton
import com.example.scareme.ui.common.ScareMeTextField
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    onSignUpClick: (String, String) -> Unit,
    viewModel: SignUpViewModel= koinViewModel()
){
    SignUpContent(
        onSignUpClick = { email, password ->
            viewModel.signUp(email, password)
            onSignUpClick(email, password) // Navigate after signup
        }
    )
}
@Composable
fun SignUpContent(
    onSignUpClick: (String, String) -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }
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
                text = stringResource(R.string.sign_up_text),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(5.dp))
            ScareMeTextField(label = stringResource(R.string.e_mail), text = email, onValueChange= {email=it} )
            Spacer(modifier = Modifier.height(8.dp))
            ScareMeTextField(label = stringResource(R.string.password), text = password, onValueChange = {password=it})
            Spacer(modifier = Modifier.height(8.dp))
            ScareMeTextField(label = stringResource(R.string.repeat_password), text = repeatPassword, onValueChange = {repeatPassword=it})
            Spacer(modifier = Modifier.height(300.dp))
            ScareMeButton(
                stringResource(R.string.sign_up),
                onClick = {
                    if (password == repeatPassword) {
                        onSignUpClick(email, password)
                    } else {
                        // Handle password mismatch error
                        println("Passwords do not match")
                    }
                }
            )
        }
    }
}





//@Preview(showBackground = true)
//@Composable
//fun SignUpScreenPreview() {
//    SignUpScreen(onClick={})
//}