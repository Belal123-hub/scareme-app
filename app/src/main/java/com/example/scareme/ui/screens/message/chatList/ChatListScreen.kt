package com.example.scareme.ui.screens.message.chatList

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.domain.chat.model.ChatItem
import com.example.domain.chat.model.User
import com.example.scareme.R
import com.example.scareme.ui.screens.main.model.UserUi
import com.example.scareme.ui.theme.ScareMeTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChatListScreen(viewModel: ChatListViewModel = koinViewModel()) {
    val chatList by viewModel.chatList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E001E))
    ) {
        SectionHeader(title = "Last")
        ProfileThumbnails(chatList) // Empty list for now, update as needed
        SectionHeader(title = "Messages")
        MessagePreviews(chatList)
    }
}

@Composable
fun ProfileThumbnails(chatList: List<ChatItem>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(chatList.take(4)) { chatItem -> // Limit to 4 items
            Column(
                modifier = Modifier
                    .padding(end = 16.dp)
            ) {
                AsyncImage(
                    model = chatItem.chat.avatar,
                    contentDescription = null,
                    modifier = Modifier
                        .size(82.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = chatItem.chat.title,
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

@Composable fun SectionHeader(title: String) {
    Text( text = title, fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(16.dp),
        fontFamily = FontFamily(Font(R.font.baloopaaaji))
    )
}

@Composable
fun MessagePreviews(chatList: List<ChatItem>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(chatList) { chatItem ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp) // Add padding to the Row
            ) {
                AsyncImage(
                    model = chatItem.chat.avatar,
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier.padding(start = 16.dp), // Add padding to the Column
                    horizontalAlignment = Alignment.Start, // Align text to the left
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = chatItem.chat.title,
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.montserratbold))
                    )
                    Text(
                        text = chatItem.lastMessage?.text?: "", // Use Elvis operator to provide a default value if lastMessage is null
                        fontSize = 16.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.baloopaaaji))
                    )
                }
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding( 14.dp), // Add padding to the Divider
                color = Color(0xFFB14623), // Set the divider color to #B14623
                thickness = 1.dp // Change the thickness as needed
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatListScreenPreview() {
    ScareMeTheme {
        ChatListScreen()
    }
}