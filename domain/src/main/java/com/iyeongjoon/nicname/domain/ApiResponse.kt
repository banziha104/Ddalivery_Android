package com.iyeongjoon.nicname.domain


data class ApiResponse<T> (
    val code: String,
    val message: String,
    val data: T
)


data class Token (
    val token: String
)
