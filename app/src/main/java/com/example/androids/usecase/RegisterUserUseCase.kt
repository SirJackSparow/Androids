package com.example.androids.usecase

import com.example.androids.data.model.AuthentificationModel
import com.example.androids.repositories.AuthRepo
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(private val authRepo: AuthRepo) {

    suspend operator fun invoke(authentificationModel: AuthentificationModel) =
        authRepo.addDataUser(authentificationModel)
}