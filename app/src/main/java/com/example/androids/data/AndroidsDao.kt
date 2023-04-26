package com.example.androids.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androids.data.model.AuthentificationModel

@Dao
interface AndroidsDao {

    @Query("select * from auth where phoneNumber = :phoneNumber")
    suspend fun getUser(phoneNumber: String) : AuthentificationModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(authentificationModel: AuthentificationModel)
}
