package com.example.scareme.di


import com.example.domain.auth.useCase.IsUserSignedInUseCase
import com.example.domain.auth.useCase.IsUserSignedInUseCaseImpl
import com.example.domain.auth.useCase.SetIsUserSignedInUseCase
import com.example.domain.auth.useCase.SetIsUserSignedInUseCaseImpl
import com.example.domain.auth.useCase.SignInUseCase
import com.example.domain.auth.useCase.SignInUseCaseImpl
import com.example.domain.auth.useCase.SignOutUseCase
import com.example.domain.auth.useCase.SignOutUseCaseImpl
import com.example.domain.auth.useCase.SignUpUseCase
import com.example.domain.auth.useCase.SignUpUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::IsUserSignedInUseCaseImpl) { bind<IsUserSignedInUseCase>() }
    factoryOf(::SignInUseCaseImpl) { bind<SignInUseCase>() }
    factoryOf(::SignUpUseCaseImpl) { bind<SignUpUseCase>() }
    factoryOf(::SignOutUseCaseImpl) { bind<SignOutUseCase>() }
    factoryOf(::SetIsUserSignedInUseCaseImpl) { bind<SetIsUserSignedInUseCase>() }
}