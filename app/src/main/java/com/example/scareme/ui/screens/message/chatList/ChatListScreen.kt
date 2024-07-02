package com.example.scareme.ui.screens.message.chatList

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.domain.chat.model.ChatItem
import com.example.scareme.R
import com.example.scareme.ui.navigation.BottomNavigationBar
import com.example.scareme.ui.screens.main.MainScreenViewModel
import com.example.scareme.ui.screens.main.model.UserUi
import com.example.scareme.ui.theme.ScareMeTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChatListScreen(viewModel: ChatListViewModel = koinViewModel()) {
    val chatList by viewModel.chatList.collectAsState()
    val likedUsers by viewModel.likedUsers.collectAsState()


    Log.d("ChatListScreen", "Chat list size: ${chatList.size}")
    Log.d("ChatListScreen", "Liked users size: ${likedUsers.size}")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E001E))
    ) {
        StatusBar()
        SectionHeader(title = "Last")
        ProfileThumbnails(likedUsers)
        SectionHeader(title = "Messages")
        MessagePreviews(chatList)
    }
}

@Composable
fun ProfileThumbnails(likedUsers: List<UserUi>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        likedUsers.forEach { user ->
            Column(
                modifier = Modifier
                    .padding(end = 16.dp)
            ) {
                AsyncImage(
                    model = user.avatar,
                    contentDescription = user.name,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = user.name ?: "",
                    fontSize = 14.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    fontFamily = FontFamily(Font(R.font.baloopaaaji))
                )
            }
        }
    }
}
@Composable
fun StatusBar() {
    // Add your status bar here
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(16.dp),
        fontFamily = FontFamily(Font(R.font.baloopaaaji))
    )
}

@Composable
fun MessagePreviews(chatList: List<ChatItem>) {
    Column {
        chatList.forEach { chatItem ->
            Text(
                text = "${chatItem.chat.title}: ${chatItem.lastMessage.text}",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ChatListScreenPreview() {
//    ScareMeTheme {
//        ChatListScreen()
//    }
//}
