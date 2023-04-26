package com.example.androids.ui.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androids.data.model.AuthentificationModel
import com.example.androids.usecase.LoginUserUseCase
import com.example.androids.utils.ResultValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val login: LoginUserUseCase) : ViewModel() {


    private val _uiState by lazy { mutableStateOf<LoginUiState>(LoginUiState.Loading) }
    internal val uiState: State<LoginUiState> get() = _uiState

    fun login(phoneNumber: String) {
        viewModelScope.launch {
            login.invoke(phoneNumber).collect { result ->
                _uiState.value = when (result) {
                    is ResultValue.Success -> {
                        LoginUiState.Success(datax = result.data)
                    }

                    is ResultValue.Error -> {
                        LoginUiState.Error(message = result.errorMessage)
                    }
                }
            }
        }
    }

}

internal sealed class LoginUiState {
    object Loading : LoginUiState()
    data class Error(val message: String) : LoginUiState()
    data class Success(val datax: AuthentificationModel) : LoginUiState()
}