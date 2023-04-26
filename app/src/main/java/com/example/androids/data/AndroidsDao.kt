package com.example.androids.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androids.data.model.AuthentificationModel

@Dao
interface AndroidsDao {

    @Query("select * from auth where username = :useName and email = :email")
    suspend fun getUser(userName: String, email: String) : AuthentificationModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(authentificationModel: AuthentificationModel)
}
