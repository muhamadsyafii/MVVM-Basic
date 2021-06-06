package com.syafii.mvvmbasic.views.state

import com.syafii.mvvmbasic.repository.payload.responses.LoginResponses
import java.lang.Exception

sealed class LoginState {
    data class Loading(val message : String = "Loading...") : LoginState()
    data class Error (val exception: Exception) : LoginState()
    data class SuccessLogin(val data : LoginResponses) : LoginState()
}