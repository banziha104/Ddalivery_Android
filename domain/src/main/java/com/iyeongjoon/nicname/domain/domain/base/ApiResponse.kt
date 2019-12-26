package com.iyeongjoon.nicname.domain.domain.base

data class ApiResponse<T> (
    val code: String,
    val message: String,
    val data: T? = null
)
