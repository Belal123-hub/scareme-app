package com.example.scareme.ui.screens.profile.profileEdit

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scareme.R
import com.example.scareme.ui.common.ScareMeButton
import com.example.scareme.ui.common.ScareMeTextField
import com.example.scareme.ui.screens.profile.profileEdit.component.Topic
import com.example.scareme.ui.screens.profile.profileEdit.model.TopicUi
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileEditScreen(
    onSignInSuccess:()->Unit,
    viewModel: ProfileEditViewModel = koinViewModel()
) {
    var name by remember { mutableStateOf("") }
    var about by remember { mutableStateOf("") }

    val topics by viewModel.topics.collectAsState()
  //  val updateStatus by viewModel.updateStatus.collectAsState()

    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        launch {
            viewModel.showError.collect { error ->
                Toast.makeText(context, error, Toast.LENGTH_LONG).show()
            }
        }

        launch {
            viewModel.navigateToMain.collect {
                onSignInSuccess()
            }
        }
    }

    ProfileEditContent(
        name = name,
        onNameChange = { name = it },
        about = about,
        onAboutChange = { about = it },
        onSaveButton = {
            val selectedTopics = topics.filter { it.isSelected }.map { it.id }
            viewModel.updateProfile(name, about, selectedTopics)
        },
        topics = topics,
        onTopicClick = viewModel::onTopicSelected
    )


}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ProfileEditContent(
    name: String,
    onNameChange: (String) -> Unit,
    about: String,
    onAboutChange: (String) -> Unit,
    onSaveButton: () -> Unit,
    topics: List<TopicUi> = emptyList(),
    onTopicClick: (String) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E001E)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
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
                color = Color.White
            )
            Image(
                painter = painterResource(id = R.drawable.group_7),
                contentDescription = stringResource(R.string.pick_up_a_profile_photo),
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            ScareMeTextField(label = stringResource(R.string.user_name), text = name, onValueChange = onNameChange)
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = about,
                onValueChange = onAboutChange,
                label = { Text(text = " label ", color = Color.White) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(Color(0xFF3A003A), shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    cursorColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White
                )
            )
            Text(
                text = stringResource(R.string.party_topics),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                items(topics.chunked(3)) { rowTopics ->
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        items(rowTopics) { topic ->
                            Topic(topic.id, topic.title, topic.isSelected, onTopicClick)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(200.dp))
            ScareMeButton(stringResource(R.string.save), onSaveButton)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ProfileEditScreenPreview() {
//    ProfileEditScreen()
//}
