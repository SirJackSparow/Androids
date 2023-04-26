package com.example.androids.repositories

import com.example.androids.data.model.AuthentificationModel
import com.example.androids.utils.ResultValue
import kotlinx.coroutines.flow.Flow

interface AuthRepo {

    suspend fun getUser(phoneNumber: String,): Flow<ResultValue<AuthentificationModel>>

    suspend fun addDataUser(authentificationModel: AuthentificationModel)
}