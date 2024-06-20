package com.example.scareme.ui.screens.profile.profileEdit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.scareme.ui.screens.profile.profileEdit.component.Topic
import com.example.scareme.ui.screens.profile.profileEdit.model.TopicUi
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileEditScreen(
    viewModel: ProfileEditViewModel= koinViewModel()
){
    val topics by viewModel.topics.collectAsState()

    ProfileEditContent(
        onSaveButton={},
        topics = topics,
        onTopicClick = viewModel::onTopicSelected,
    )
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProfileEditContent(
    onSaveButton:()->Unit,
    topics: List<TopicUi> = emptyList(),
    onTopicClick: (String) -> Unit = {}
){
    var name by remember { mutableStateOf("") }
    var about by remember { mutableStateOf("") }
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
            ScareMeTextField(label = stringResource(R.string.user_name), text = name, onValueChange = {name=it})
            Spacer(modifier = Modifier.height(8.dp))
            ScareMeTextField(label = stringResource(R.string.about_user), text = about, onValueChange = {about=it})
            Text(
                text = stringResource(R.string.party_topics),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )

            FlowRow {
                topics.forEach { topic ->
                    Topic(topic.id, topic.title, topic.isSelected, onTopicClick)
                }
            }

            Spacer(modifier = Modifier.height(200.dp))
            ScareMeButton(stringResource(R.string.save),onSaveButton)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileEditScreenPreview() {
    ProfileEditScreen()
}

