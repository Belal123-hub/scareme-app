package com.example.scareme.ui.screens.auth.signIn


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.scareme.R
import com.example.scareme.ui.common.ScareMeButton
import com.example.scareme.ui.common.ScareMeTextField
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignInScreen(
    onSignInSuccess: () -> Unit,
    viewModel: SignInViewModel= koinViewModel()
){
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        launch {
            viewModel.showError.collect { error ->
                Toast.makeText(context, error, Toast.LENGTH_LONG).show()
            }
        }

        launch {
            viewModel.navigateToMain.collect {
                onSignInSuccess()
            }
        }
    }
    SignInContent(
        onSignInClick=viewModel::signIn
    )
}
@Composable
fun SignInContent(
    onSignInClick: (String,String) -> Unit,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
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
                text = stringResource(R.string.sign_in_text),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily(Font(R.font.baloopaaaji))
            )
            Spacer(modifier = Modifier.height(5.dp))
            ScareMeTextField(label = stringResource(R.string.e_mail), text = email, onValueChange ={email=it} )
            Spacer(modifier = Modifier.height(8.dp))
            ScareMeTextField(label = stringResource(R.string.password), text = password, onValueChange = {password=it},isPassword = true)

            Spacer(modifier = Modifier.height(300.dp))
           ScareMeButton(stringResource(R.string.sign_in), onClick = {onSignInClick(email,password)})
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun SignUpScreenPreview() {
//    SignInScreen(
//        onSignInClick = { _, _ ->}
//    )
//}