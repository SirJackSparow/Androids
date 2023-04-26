package com.example.androids.repositories

import com.example.androids.data.datasource.LocalDataSource
import com.example.androids.data.model.AuthentificationModel
import com.example.androids.utils.ResultValue
import com.example.androids.utils.getResultValue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(private val localDataSource: LocalDataSource) : AuthRepo {
    override suspend fun getUser(phoneNumber: String): Flow<ResultValue<AuthentificationModel>> {
        return flow {
            val db = getResultValue { localDataSource.getUser(phoneNumber) }
            if (db is ResultValue.Success) {
                emit(db)
            } else {
                emit(ResultValue.Error("Error", (db as ResultValue.Error).throwable))
            }
        }
    }

    override suspend fun addDataUser(authentificationModel: AuthentificationModel) {
        localDataSource.addDataUser(authentificationModel)
    }
}