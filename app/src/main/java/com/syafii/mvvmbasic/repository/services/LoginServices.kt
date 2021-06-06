package com.syafii.mvvmbasic.repository.services

import com.syafii.mvvmbasic.repository.payload.requests.LoginRequest
import com.syafii.mvvmbasic.repository.payload.responses.LoginResponses
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginServices {
    @POST("/api/login")
    suspend fun getLogin(@Body loginBody: LoginRequest) : LoginResponses
}