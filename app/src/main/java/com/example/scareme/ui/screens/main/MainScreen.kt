package com.example.scareme.ui.screens.main

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import com.example.scareme.ui.screens.main.model.profiles
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    onClick: () -> Unit,
    viewModel: MainScreenViewModel = koinViewModel()
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
    var currentIndex by remember { mutableStateOf(0) }
    val user = userInformation.getOrNull(currentIndex)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(vertical = 23.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val states = userInformation.map { rememberSwipeableCardState() }

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
                        .padding(start = 12.dp, bottom = 12.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                val scope = rememberCoroutineScope()
                user?.let { currentUser ->
                    val state = states[currentIndex]
                    Box(
                        modifier = Modifier
                            .offset(y = 50.dp)
                            .size(height = 508.dp, width = 318.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        ProfileCard(
                            modifier = Modifier
                                .fillMaxSize()
                                .swipableCard(
                                    state = state,
                                    blockedDirections = listOf(Direction.Down),
                                    onSwiped = { direction ->
                                        when (direction) {
                                            Direction.Left -> viewModel.dislikeUser(currentUser.userId)
                                            Direction.Right -> viewModel.likeUser(currentUser.userId)
                                            Direction.Up -> TODO()
                                            Direction.Down -> TODO()
                                        }
                                        currentIndex++
                                    },
                                    onSwipeCancel = {
                                        Log.d("Swipeable-Card", "Cancelled swipe")
                                    }
                                ),
                            name = currentUser.name,
                            avatar = currentUser.avatar
                        )

                        LaunchedEffect(state.swipedDirection) {
                            if (state.swipedDirection != null) {
                                // Handle swipe action here, e.g., send user ID to the API
                                currentIndex++
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
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CircleButton(
                        onClick = {
                            scope.launch {
                                if (currentIndex < states.size) {
                                    states[currentIndex].swipe(Direction.Left)
                                    viewModel.dislikeUser(userInformation[currentIndex].userId)
                                    currentIndex++
                                }
                            }
                        },
                        icon = Icons.Rounded.Close
                    )
                    CircleButton(
                        onClick = {
                            scope.launch {
                                if (currentIndex < states.size) {
                                    states[currentIndex].swipe(Direction.Right)
                                   viewModel.likeUser(userInformation[currentIndex].userId)
                                    currentIndex++
                                }
                            }
                        },
                        icon = Icons.Rounded.Favorite
                    )
                }
            }
        }
    }
}




@Composable
fun CircleButton(
    onClick: () -> Unit,
    icon: ImageVector,
) {
    IconButton(
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.Red)
            .size(56.dp)
            .border(2.dp, Color.Black, CircleShape),
        onClick = onClick
    ) {
        Icon(icon, null, tint = Color.Black)
    }
}

@Composable
fun ProfileCard(
    modifier: Modifier,
    name: String?,
    avatar: String?,
) {
    Card(modifier) {
        Box {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current).data(avatar)
                    .crossfade(true).build(),
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
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }
}


