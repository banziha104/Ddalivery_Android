package com.iyeongjoon.nicname.data.api

import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.data.form.auth.LoginForm
import com.iyeongjoon.nicname.data.form.auth.SignUpForm
import com.nhaarman.mockitokotlin2.mock
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.TimeUnit

class AuthApiTest {

    val authApi = AuthApi()

    @Test
    fun signup() {
        authApi
            .auth()
            .signUp(SignUpForm("test", "testps", "김테스트", "부천시", "1313", "1313", "01011112222"))
            .doOnNext{print(it)}
            .test()
            .awaitDone(3, TimeUnit.SECONDS)
            .assertValue { it.code == "OK" }
            .assertComplete()
    }


    @Test
    fun login() {
        authApi
            .auth()
            .login(LoginForm("test", "testps"))
            .doOnNext { print(it) }
            .test()
            .awaitDone(3, TimeUnit.SECONDS)
            .assertValue {
                it.code == "OK"
            }
            .assertComplete()
    }

}