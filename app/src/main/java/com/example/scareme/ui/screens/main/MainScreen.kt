package com.example.scareme.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.scareme.R
import com.example.scareme.ui.screens.main.model.UserUi
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(viewModel: MainScreenViewModel= koinViewModel()){
    val users by viewModel.users.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E001E))
    ) {
        items(users) { user ->
            MainScreenContent(user)
        }
    }

}

@Composable
fun MainScreenContent(user: UserUi){

    Box(
        modifier = Modifier
            .background(
                Color(0xFF1E001E),
                shape = RoundedCornerShape(4.dp)
            )
            .fillMaxSize()
    ){
        Box(){


            Image(
                painter = painterResource(
                    R.drawable.background),
                contentDescription = stringResource(R.string.background_upper_screen),
                modifier = Modifier
                    .fillMaxWidth()
                    .width(360.dp)
                    .height(344.dp)
            )
            Text(
                text = stringResource(R.string.trick_or_treat),
                modifier=Modifier.padding(start = 130.dp),
                textAlign = TextAlign.Center,
                color =Color.White,
                fontWeight = FontWeight.Bold,
                style = typography.titleLarge
            )

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .fillMaxWidth()
            ) {
                user.avatar?.let {
                    // Avatar
                    Image(
                        painter = rememberImagePainter(
                            data = user.avatar ?: "",
                            builder = {
                                placeholder(R.drawable.placeholder_avatar)
                                error(R.drawable.placeholder_avatar)
                            }
                        ),
                        contentDescription = "User Avatar",
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(Color.Gray),
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    text = user.name ?: "Unknown",
                   // style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = user.aboutMyself ?: "",
                   // style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = user.topics.joinToString(", ") { it.title },
                //    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }


    }

}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}