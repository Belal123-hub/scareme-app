package com.example.scareme.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.scareme.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScareMeTextField(
    label: String,
    text: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false // Add this parameter
) {
    var passwordVisible by remember { mutableStateOf(false) }


    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.baloopaaaji))
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF3A003A), shape = RoundedCornerShape(8.dp)),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            cursorColor = Color.White,
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.White
        ),
        singleLine = true,
        textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            if (isPassword) {
                val icon = if (passwordVisible) R.drawable._491953_ui_eye_hide_view_look_icon else R.drawable._473003_hide_hide_eye_hide_password_icon
                Icon(
                    imageVector = ImageVector.vectorResource(id = icon),
                    contentDescription = if (passwordVisible) "Hide password" else "Show password",
                    modifier = Modifier
                        .clickable {
                            passwordVisible = !passwordVisible
                        }
                        .size(24.dp) // Adjust the icon size here
                )
            }
        }
    )
}



