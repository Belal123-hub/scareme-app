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
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.google.accompanist.systemuicontroller.rememberSystemUiController
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
    userInformation: List<UserUi>,
    viewModel: MainScreenViewModel,
    modifier: Modifier
) {
    var currentIndex by rememberSaveable { mutableStateOf(0) }
    val user = userInformation.getOrNull(currentIndex)

    TransparentSystemBars()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .systemBarsPadding()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 400.dp, height = 370.dp),
            painter = painterResource(id = R.drawable.background),
            contentDescription = null
        )

        val scope = rememberCoroutineScope()
        user?.let {
            val state = rememberSwipeableCardState()
            Box(
                Modifier
                    .padding(18.dp)
                    .fillMaxSize()
                    .aspectRatio(1f)
                    .align(Alignment.Center)
            ) {
                ProfileCard(
                    modifier = Modifier
                        .fillMaxSize()
                        .swipableCard(
                            state = state,
                            blockedDirections = listOf(Direction.Down),
                            onSwiped = {
                                currentIndex++
                            },
                            onSwipeCancel = {
                                Log.d("Swipeable-Card", "Cancelled swipe")
                            }
                        ),
                    name = user.name,
                    avatar = user.avatar
                )

                LaunchedEffect(state.swipedDirection) {
                    if (state.swipedDirection != null) {
                        // Handle swipe action here, e.g., send user ID to the API
                        when (state.swipedDirection) {
                            Direction.Left -> {
                                // viewModel.likeUser(user.userId)
                                // Send to dislike API
                            }
                            Direction.Right -> {
                                // viewModel.dislikeUser(user.userId)
                                // Send to like API
                            }
                            else -> {}
                        }
                        currentIndex++
                    }
                }
            }
        }

        // Buttons for swiping programmatically
        Row(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 24.dp, vertical = 32.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CircleButton(
                onClick = {
                    currentIndex++
                },
                icon = Icons.Rounded.Close
            )
            CircleButton(
                onClick = {
                    currentIndex++
                },
                icon = Icons.Rounded.Favorite
            )
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

@Composable
fun TransparentSystemBars() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = false

    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons,
            isNavigationBarContrastEnforced = false
        )
        onDispose {}
    }
}
