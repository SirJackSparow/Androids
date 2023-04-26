package com.example.androids.repositories

import com.example.androids.data.datasource.LocalDataSource
import com.example.androids.data.model.AuthentificationModel
import com.example.androids.utils.ResultValue
import com.example.androids.utils.getResultValue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthRepoImpl(private val localDataSource: LocalDataSource) : AuthRepo {
    override suspend fun getUser(phoneNumber: String): Flow<ResultValue<AuthentificationModel>> {
        return flow {
            val db = getResultValue { localDataSource.getUser(phoneNumber) }
        }
    }

    override suspend fun addDataUser(authentificationModel: AuthentificationModel) {
        localDataSource.addDataUser(authentificationModel)
    }
}