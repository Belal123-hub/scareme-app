package com.example.scareme.ui.screens.profile.profileInfo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.domain.profile.model.Profile
import com.example.scareme.R
import com.example.scareme.ui.screens.profile.profileEdit.component.Topic
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
                .background(
                    Color(0xFF1E001E),
                    shape = RoundedCornerShape(4.dp)
                )
                .fillMaxSize()
              //  .paint(painterResource(id = R.drawable.background))
        ){
            //Spacer(modifier = Modifier.height(20.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Image(
                    painter = painterResource(
                        R.drawable.background),
                    contentDescription = stringResource(R.string.background_upper_screen),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(344.dp)
                )

                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(profile.avatar)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.group_7),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(300.dp)
                        .clip(CircleShape)
                        // .align(Alignment.Center)
                        .offset(y = 50.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = it.name,
                    modifier= Modifier
                        .padding(start = 130.dp)
                        .padding(top = 277.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                items(it.topics.chunked(3)) { rowTopics ->
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        items(rowTopics) { topic ->
                            Topic(title = topic.title)
                            //Text(text =topic.title)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = it.aboutMyself,
                color = Color.White
                )



        }
    }
}

@Composable
fun Topic(
    title: String
) {
    Box (
        modifier = Modifier
           // .background(Color(0xFFFF7F27))
            .padding(horizontal = 4.dp, vertical = 4.dp)
            //.border(BorderStroke(2.dp, Color(0xFFFF7F27)), shape = RoundedCornerShape(18.dp))
    ){
        Text(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFFFA500)),
                //.clickable { onTopicClick.invoke(id) },
            text = title,
            fontWeight = FontWeight.Bold,
            color =  Color.Black,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileInfoScreen()
}