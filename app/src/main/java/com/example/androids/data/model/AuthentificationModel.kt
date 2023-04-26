package com.example.androids.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androids.utils.Utils.EMPTY_STRING

@Entity(tableName = "auth")
data class AuthentificationModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val username: String? = EMPTY_STRING,
    val email: String? = EMPTY_STRING,
    val phoneNumber: String? = EMPTY_STRING
)
