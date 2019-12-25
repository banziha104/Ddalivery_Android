package com.iyeongjoon.nicname.data.api.auth

import android.media.session.MediaSession
import com.iyeongjoon.nicname.data.form.auth.LoginForm
import com.iyeongjoon.nicname.data.form.auth.SignUpForm
import com.iyeongjoon.nicname.domain.ApiResponse
import com.iyeongjoon.nicname.domain.TestModel
import com.iyeongjoon.nicname.domain.Token
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApiContract{
    @POST("account/signup")
    fun signUp(@Body signUpForm: SignUpForm) : Observable<ApiResponse<String>>

    @POST("account/login")
    fun login(@Body loginForm: LoginForm) : Observable<ApiResponse<Token>>
}