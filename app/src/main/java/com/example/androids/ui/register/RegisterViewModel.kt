package com.example.androids.ui.register

import androidx.lifecycle.ViewModel
import com.example.androids.data.model.AuthentificationModel
import com.example.androids.usecase.RegisterUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val register: RegisterUserUseCase) :
    ViewModel() {


    suspend fun register(authentificationModel: AuthentificationModel) =
        withContext(Dispatchers.IO) {
            register.invoke(authentificationModel)
        }
}
