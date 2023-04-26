package com.example.androids.di

import android.content.Context
import androidx.room.Room
import com.example.androids.data.AndroidsDao
import com.example.androids.data.Databases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDb(
        @ApplicationContext context: Context
    ): Databases = Room.databaseBuilder(context, Databases::class.java, "androids")
        .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideAndroidsDao(appDatabase: Databases): AndroidsDao = appDatabase.androidsDao()
}
