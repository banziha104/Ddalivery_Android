package com.iyeongjoon.nicname.data.api.auth

import com.iyeongjoon.nicname.data.form.auth.LoginForm
import com.iyeongjoon.nicname.data.form.auth.SignUpForm
import com.iyeongjoon.nicname.domain.domain.auth.Token
import com.iyeongjoon.nicname.domain.domain.base.ApiResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiContract{
    @POST("account/signup")
    fun signUp(@Body signUpForm: SignUpForm) : Observable<ApiResponse<String>>

    @POST("account/login")
    fun login(@Body loginForm: LoginForm) : Observable<ApiResponse<Token>>
}