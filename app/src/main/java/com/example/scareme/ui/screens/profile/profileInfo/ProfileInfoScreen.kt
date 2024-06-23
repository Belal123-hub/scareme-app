package com.example.scareme.ui.screens.profile.profileInfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.profile.model.Profile
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileInfoScreen(viewModel: ProfileInfoViewModel=koinViewModel()){
    val profile by viewModel.profile.collectAsState()

    profile?.let { ProfileInfoContent(profile = it) }

}

@Composable
fun ProfileInfoContent(profile:Profile){
    profile.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Name: ${it.name}")
            Text(text = "About: ${it.aboutMyself}")
            // Handle Avatar and Topics
            it.topics.forEach { topic ->
                Text(text = "Topic: ${topic.title}")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileInfoScreen()
}