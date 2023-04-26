package com.example.androids.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androids.data.model.AuthentificationModel

@Database(
    entities = [AuthentificationModel::class],
    version = 1,
    exportSchema = false
)
abstract class Databases : RoomDatabase(){
    abstract fun androidsDao(): AndroidsDao
}
