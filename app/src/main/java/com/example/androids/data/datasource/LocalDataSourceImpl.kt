package com.example.androids.data.datasource

import com.example.androids.data.AndroidsDao
import com.example.androids.data.model.AuthentificationModel
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val dao: AndroidsDao
) : LocalDataSource{
    override suspend fun getUser(user: AuthentificationModel) {

    }

    override suspend fun addDataUser(user: AuthentificationModel) {

    }
}