package com.example.scareme.di


import com.example.domain.accessToken.AccessTokenRepository
import com.example.domain.accessToken.AccessTokenRepositoryImpl
import com.example.domain.auth.AuthRepository
import com.example.domain.auth.AuthRepositoryImpl
import com.example.domain.chat.ChatRepository
import com.example.domain.chat.ChatRepositoryImpl
import com.example.domain.profile.ProfileRepository
import com.example.domain.profile.ProfileRepositoryImpl
import com.example.domain.users.UserRepository
import com.example.domain.users.UserRepositoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import org.koin.core.module.dsl.bind

val repositoryModule = module {
    factoryOf(::AuthRepositoryImpl) { bind<AuthRepository>() }
    factoryOf(::AccessTokenRepositoryImpl) { bind<AccessTokenRepository>()}
    factoryOf(::ProfileRepositoryImpl) { bind<ProfileRepository>() }
    factoryOf(::UserRepositoryImpl) { bind<UserRepository>() }
    factoryOf(::ChatRepositoryImpl) { bind<ChatRepository>() }

}