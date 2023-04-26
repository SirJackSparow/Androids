package com.example.androids.usecase

import com.example.androids.data.model.AuthentificationModel
import com.example.androids.repositories.AuthRepo
import com.example.androids.utils.ResultValue
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(private val authRepo: AuthRepo) {

    suspend operator fun invoke(phoneNumber: String): Flow<ResultValue<AuthentificationModel>> =
        authRepo.getUser(phoneNumber)
}