package com.example.androids.repositories

import com.example.androids.data.datasource.LocalDataSource
import com.example.androids.data.model.AuthentificationModel
import com.example.androids.utils.ResultValue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthRepoImpl(private val localDataSource: LocalDataSource) : AuthRepo {
    override suspend fun getUser(userName: String, email: String ): Flow<ResultValue<AuthentificationModel>> {
        return flow {

        }
    }

    override suspend fun addDataUser() {

    }
}