package com.example.androids.utils

object Utils {

    const val EMPTY_STRING = ""
}

sealed class ResultValue<out R> {
    data class Success<out T>(val data: T) : ResultValue<T>()
    data class Error(val errorMessage: String, val throwable: Throwable) : ResultValue<Nothing>()
}

suspend fun <T> getResultValue(invoke: suspend () -> T): ResultValue<T> {
    return runCatching {
        ResultValue.Success(invoke())
    }.getOrElse {
        ResultValue.Error("Error", it)
    }
}
