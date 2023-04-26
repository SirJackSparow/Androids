package com.example.androids.di

import com.example.androids.data.datasource.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataSourceModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(localDataSource: LocalDataSource): LocalDataSource = localDataSource
}