package com.syafii.mvvmbasic.repository.contract

import com.syafii.mvvmbasic.repository.payload.requests.LoginRequest
import com.syafii.mvvmbasic.repository.payload.responses.LoginResponses
import com.syafii.mvvmbasic.repository.services.LoginServices

class LoginContractImpl(val service : LoginServices) : LoginContractRepo {
    override suspend fun getLogin(loginRequest: LoginRequest) = service.getLogin(loginRequest)
}