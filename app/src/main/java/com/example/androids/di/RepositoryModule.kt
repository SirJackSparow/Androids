package com.example.androids.di

import com.example.androids.repositories.AuthRepo
import com.example.androids.repositories.AuthRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesAuthRepository(authRepository: AuthRepoImpl) : AuthRepo = authRepository
}