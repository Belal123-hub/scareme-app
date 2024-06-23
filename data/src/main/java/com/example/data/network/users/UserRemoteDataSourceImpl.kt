package com.example.data.network.users

import com.example.domain.profile.model.Topic
import com.example.domain.users.UserRemoteDataSource
import com.example.domain.users.model.User

class UserRemoteDataSourceImpl (
    private val userApi: UserApi
): UserRemoteDataSource {
   override suspend fun getAllUsers():List<User>{
return userApi.getAllUsers().map { user->
    User(
        userId = user.userId,
        name = user.name,
        aboutMyself = user.aboutMyself,
        avatar = user.avatar,
        topics = user.topics.map { topic ->
            Topic(
                id = topic.id,
                title = topic.title
            )
        }
    )
}

    }

}