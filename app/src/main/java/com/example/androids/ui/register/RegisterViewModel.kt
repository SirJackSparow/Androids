package com.example.androids.ui.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androids.data.model.AuthentificationModel
import com.example.androids.ui.login.LoginUiState
import com.example.androids.usecase.RegisterUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val register: RegisterUserUseCase) :
    ViewModel() {

    private val _uiState by lazy { mutableStateOf<RegisterUiState>(RegisterUiState.Loading) }
    val uiState: State<RegisterUiState> get() = _uiState

    suspend fun register(authentificationModel: AuthentificationModel) =
        withContext(Dispatchers.IO) {
            if (isValidEmail(authentificationModel.email ?: "")) {
                register.invoke(authentificationModel)
                _uiState.value = RegisterUiState.Success
            } else {
                _uiState.value = RegisterUiState.Error
            }

        }

    fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        return emailRegex.matches(email)
    }
}

sealed class RegisterUiState {
    object Loading : RegisterUiState()
    object Error : RegisterUiState()
    object Success : RegisterUiState()
}
