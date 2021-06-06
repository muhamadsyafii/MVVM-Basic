package com.syafii.mvvmbasic.repository.contract

import com.syafii.mvvmbasic.repository.payload.requests.LoginRequest
import com.syafii.mvvmbasic.repository.payload.responses.LoginResponses

interface LoginContractRepo {
    suspend fun getLogin(loginRequest: LoginRequest) : LoginResponses
}