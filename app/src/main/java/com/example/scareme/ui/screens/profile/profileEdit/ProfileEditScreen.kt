package com.example.scareme.ui.screens.profile.profileEdit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scareme.R
import com.example.scareme.ui.common.ScareMeButton
import com.example.scareme.ui.common.ScareMeTextField

@Composable
fun ProfileEditScreen(
    onSaveButton:()->Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E001E)),
        contentAlignment = Alignment.Center
    ) {

        Column(
             horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = stringResource(R.string.why_are_you_scary),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                // textAlign = TextAlign.Start
            )
            Image(
                painter = painterResource(id = R.drawable.group_7),
                contentDescription = stringResource(R.string.pick_up_a_profile_photo),
                modifier= Modifier
                    .width(150.dp)
                    .height(150.dp)

            )
            Spacer(modifier = Modifier.height(5.dp))
            ScareMeTextField(label = stringResource(R.string.user_name))
            Spacer(modifier = Modifier.height(8.dp))
            ScareMeTextField(label = stringResource(R.string.about_user))

            Spacer(modifier = Modifier.height(200.dp))
            ScareMeButton(stringResource(R.string.save),onSaveButton)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileEditScreenPreview() {
    ProfileEditScreen(onSaveButton={})
}

