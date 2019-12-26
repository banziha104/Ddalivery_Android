package com.iyeongjoon.nicname.data.api

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.data.form.auth.LoginForm
import com.iyeongjoon.nicname.data.form.auth.SignUpForm
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuthApiTest {

    @Before
    fun setUp(){

    }

    @Test
    fun signUp(){
        AuthApi()
            .auth()
            .signUp(SignUpForm("test","testps","김테스트","부천시","01011112222"))
            .test()
            .assertNoErrors()
            .assertSubscribed()
            .assertValue{
                println(it)
                it.code.contentEquals("OK")
            }
    }

    @Test
    fun login(){
        AuthApi()
            .auth()
            .login(LoginForm("test","testps"))
//            .blockingFirst()
            .test()
            .assertNoErrors()
            .assertSubscribed()
            .assertValue{
                it.code.contentEquals("OK")
            }
            .dispose()
    }

}