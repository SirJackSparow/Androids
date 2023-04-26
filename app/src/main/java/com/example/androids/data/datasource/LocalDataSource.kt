package com.example.androids.data.datasource

import com.example.androids.data.model.AuthentificationModel

interface LocalDataSource {

    suspend fun getUser(user: AuthentificationModel)

    suspend fun addDataUser(user: AuthentificationModel)
}
