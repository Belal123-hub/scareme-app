package com.example.scareme.ui.screens.main

import android.util.Log
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alexstyl.swipeablecard.Direction
import com.alexstyl.swipeablecard.ExperimentalSwipeableCardApi
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.alexstyl.swipeablecard.swipableCard
import com.example.scareme.R
import com.example.scareme.ui.screens.main.model.UserUi
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = koinViewModel(),
) {
    val users by viewModel.users.collectAsState()

    MainScreenContent(
        userInformation = users,
        viewModel = viewModel,
        modifier = Modifier.fillMaxWidth()
    )
}

@OptIn(ExperimentalSwipeableCardApi::class)
@Composable
fun MainScreenContent(
    viewModel: MainScreenViewModel,
    userInformation: List<UserUi>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF1E001E))
            .padding(vertical = 23.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val states = userInformation.reversed()
            .map { it to rememberSwipeableCardState() }

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(width = 400.dp, height = 370.dp),
                painter = painterResource(id = R.drawable.background),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = "Trick or Treat?",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .offset(x = 21.dp, y = 47.dp)
                        .padding(start = 12.dp, bottom = 12.dp),
                    fontFamily = FontFamily(Font(R.font.baloopaaaji))
                )
                Spacer(modifier = Modifier.height(12.dp))
                val scope = rememberCoroutineScope()
                Box(
                    modifier = Modifier
                        .offset(y = 50.dp)
                        .size(height = 508.dp, width = 318.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    states.forEach { (it, state) ->
                        if (state.swipedDirection == null) {

                            ProfileCard(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .swipableCard(
                                        state = state,
                                        blockedDirections = listOf(Direction.Down),
                                        onSwiped = {
                                            // Handle swipes
                                        },
                                        onSwipeCancel = {
                                            Log.d("Swipeable-Card", "Cancelled swipe")
                                        }
                                    ),
                                name = it.name,
                                avatar = it.avatar
                            )

                        }

                        LaunchedEffect(it, state.swipedDirection) {
                            if (state.swipedDirection != null) {
                                // Handle swipe action here, e.g., send user ID to the API
                                when (state.swipedDirection) {
                                    Direction.Left -> {
                                        viewModel.dislikeUser(it.userId)
                                        // Send to dislike API
                                    }

                                    Direction.Right -> {
                                        viewModel.likeUser(it.userId)
                                        // Send to like API
                                    }

                                    else -> {}
                                }
                            }
                        }
                    }
                }
                Row(
                    Modifier
                        .padding(horizontal = 31.dp)
                        .offset(y = 57.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ProfileButton(
                        icon = painterResource(id = R.drawable.close),
                        onClick = {
                            scope.launch {
                                states.lastOrNull { it.second.offset.value == Offset.Zero }?.second?.swipe(
                                    Direction.Left
                                )
                            }
                        }
                    )
                    Spacer(modifier = Modifier.width(20.dp)) // Add a spacer with a width of 20.dp
                    ProfileButton(
                        icon = painterResource(id = R.drawable.like),
                        onClick = {
                            scope.launch {
                                states.lastOrNull { it.second.offset.value == Offset.Zero }?.second?.swipe(
                                    Direction.Right
                                )
                            }
                        }
                    )
                }

            }
        }

    }
}

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    name: String?,
    avatar: String?
) {
    Card(modifier) {
        Box {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current).data(avatar)
                    .crossfade(true).build(),
                //error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.group_7),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Column(Modifier.align(Alignment.BottomStart)) {
                if (name != null) {
                    Text(
                        text = name,
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(10.dp),
                        fontFamily = FontFamily(Font(R.font.baloopaaaji))
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileButton(
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Image(
        painter = icon,
        contentDescription = null,
        modifier = modifier
            .size(77.dp)
            .clip(CircleShape)
            .clickable(onClick = onClick)
    )
}