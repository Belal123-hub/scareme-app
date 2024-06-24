//package com.example.scareme.ui.screens.main
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.gestures.detectHorizontalDragGestures
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.rounded.Close
//import androidx.compose.material.icons.rounded.Favorite
//import androidx.compose.runtime.*
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.zIndex
//import coil.compose.rememberImagePainter
//import com.example.scareme.R
//import com.example.scareme.ui.screens.main.model.UserUi
//import kotlinx.coroutines.launch
//import org.koin.androidx.compose.koinViewModel
//import kotlin.math.absoluteValue
//
//@Composable
//fun MainScreen2(viewModel: MainScreenViewModel = koinViewModel()) {
//    val users by viewModel.users.collectAsState()
//    var currentIndex by rememberSaveable { mutableStateOf(0) }
//
//    if (users.isNotEmpty()) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.Black)
//                .padding(vertical = 23.dp, horizontal = 20.dp),
//            contentAlignment = Alignment.Center
//        ) {
//            val states = users.takeLast(users.size - currentIndex).reversed()
//                .map { it to rememberSwipeableCardState() }
//            var hint by remember {
//                mutableStateOf("Swipe a card or press a button below")
//            }
//
//            Hint(hint)
//
//            val scope = rememberCoroutineScope()
//            Box(Modifier
//                .padding(24.dp)
//                .fillMaxSize()
//                .align(Alignment.Center)) {
//                states.forEachIndexed { index, (user, state) ->
//                    if (state.swipedDirection == null) {
//                        MainScreenContent(
//                            user = user,
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .padding(16.dp)
//                                .shadow(8.dp, RoundedCornerShape(8.dp))
//                                .zIndex(index.toFloat())
//                                .background(Color.White, shape = RoundedCornerShape(8.dp))
//                                .clip(RoundedCornerShape(8.dp))
//                                .padding(16.dp)
//                                .swipableCard(
//                                    state = state,
//                                    blockedDirections = listOf(Direction.Down),
//                                    onSwiped = {
//                                        // swipes are handled by the LaunchedEffect
//                                        // so that we track button clicks & swipes
//                                        // from the same place
//                                    },
//                                    onSwipeCancel = {
//                                        hint = "You canceled the swipe"
//                                    }
//                                )
//                        )
//                    }
//                    LaunchedEffect(user, state.swipedDirection) {
//                        if (state.swipedDirection != null) {
//                            hint = "You swiped ${stringFrom(state.swipedDirection!!)}"
//                        }
//                    }
//                }
//            }
////            Row(Modifier
////                .align(Alignment.BottomCenter)
////                .padding(horizontal = 24.dp, vertical = 32.dp)
////                .fillMaxWidth(),
////                horizontalArrangement = Arrangement.SpaceEvenly
////            ) {
//////                CircleButton(
//////                    onClick = {
//////                        scope.launch {
//////                            val last = states.reversed()
//////                                .firstOrNull {
//////                                    it.second.offset.value == Offset(0f, 0f)
//////                                }?.second
//////                            last?.swipe(Direction.Left)
//////                        }
//////                    },
//////                    icon = Icons.Rounded.Close
//////                )
//////                CircleButton(
//////                    onClick = {
//////                        scope.launch {
//////                            val last = states.reversed()
//////                                .firstOrNull {
//////                                    it.second.offset.value == Offset(0f, 0f)
//////                                }?.second
//////
//////                            last?.swipe(Direction.Right)
//////                        }
//////                    },
//////                    icon = Icons.Rounded.Favorite
//////                )
////            }
//        }
//    } else {
//        Text("No users available", color = Color.White)
//    }
//}
//
//@Composable
//fun MainScreenContent2(
//    user: UserUi,
//    modifier: Modifier = Modifier,
//    onDismiss: () -> Unit = {}
//) {
//    Box(
//        modifier = modifier
//            .background(Color(0xFF1E001E))
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.Black)
//                .padding(vertical = 23.dp, horizontal = 20.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text(
//                text = "Trick or Treat?",
//                fontSize = 36.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.White,
//                modifier = Modifier
//                    .align(Alignment.Start)
//                    .padding(start = 12.dp, bottom = 5.dp)
//            )
//
//            Box(
//                modifier = Modifier.fillMaxSize()
//            ) {
//                Image(
//                    painter = rememberImagePainter(
//                        data = user.avatar ?: "",
//                        builder = {
//                            placeholder(R.drawable.placeholder_avatar)
//                            error(R.drawable.placeholder_avatar)
//                        }
//                    ),
//                    contentDescription = "User Avatar",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
//
//                Box(
//                    modifier = Modifier
//                        .align(Alignment.BottomStart)
//                        .background(Color(0xff401c34), shape = RoundedCornerShape(11.dp))
//                        .fillMaxWidth()
//                        .height(53.dp)
//                        .padding(13.dp),
//                    contentAlignment = Alignment.CenterStart
//                ) {
//                    Text(
//                        text = user.name ?: "Unknown",
//                        color = Color.White,
//                        fontSize = 21.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//private fun CircleButton(
//    onClick: () -> Unit,
//    icon: ImageVector,
//) {
//    IconButton(
//        modifier = Modifier
//            .clip(CircleShape)
//            .background(MaterialTheme.colorScheme.primary)
//            .size(56.dp)
//            .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
//        onClick = onClick
//    ) {
//        Icon(icon, null,
//            tint = MaterialTheme.colorScheme.onPrimary)
//    }
//}
//
//@Composable
//private fun Hint(text: String) {
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .padding(horizontal = 24.dp, vertical = 32.dp)
//            .fillMaxWidth()
//    ) {
//        Text(
//            text = text,
//            color = MaterialTheme.colorScheme.onPrimary,
//            fontWeight = FontWeight.Bold,
//            fontSize = 22.sp,
//            textAlign = TextAlign.Center
//        )
//    }
//}
//
//@SuppressLint("ModifierFactoryUnreferencedReceiver")
//@Composable
//fun Modifier.swipableCard(
//    state: SwipeableCardState,
//    blockedDirections: List<Direction>,
//    onSwiped: () -> Unit,
//    onSwipeCancel: () -> Unit
//): Modifier {
//    val scope = rememberCoroutineScope()
//    return pointerInput(Unit) {
//        detectHorizontalDragGestures { change, dragAmount ->
//            change.consume()
//            state.offset += Offset(dragAmount, 0f)
//            if (state.offset.x.absoluteValue > 200) {
//                scope.launch {
//                    state.swipedDirection = if (state.offset.x > 0) Direction.Right else Direction.Left
//                    onSwiped()
//                }
//            } else {
//                scope.launch {
//                    state.swipedDirection = null
//                    state.offset = Offset.Zero
//                    onSwipeCancel()
//                }
//            }
//        }
//    }
//}
//
//data class SwipeableCardState(var offset: Offset = Offset.Zero, var swipedDirection: Direction? = null)
//
//@Composable
//fun rememberSwipeableCardState() = remember { SwipeableCardState() }
//
//enum class Direction { Left, Right, Up, Down }
//
//@Preview(showBackground = true)
//@Composable
//fun MainScreenPreview() {
//    MainScreen()
//}
//
//private fun stringFrom(direction: Direction): String {
//    return when (direction) {
//        Direction.Left -> "Left 👈"
//        Direction.Right -> "Right 👉"
//        Direction.Up -> "Up 👆"
//        Direction.Down -> "Down 👇"
//    }
//}
