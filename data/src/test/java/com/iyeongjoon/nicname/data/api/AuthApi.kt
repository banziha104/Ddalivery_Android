package com.iyeongjoon.nicname.data.api

import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.data.form.auth.LoginForm
import com.iyeongjoon.nicname.data.form.auth.SignUpForm
import com.nhaarman.mockitokotlin2.mock
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

class AuthApi {

    @Test
    fun signup() {
        assertEquals(
            AuthApi()
                .auth()
                .signUp(SignUpForm("test", "testps", "김테스트", "부천시", "01011112222"))
                .blockingFirst()
                .code, "OK"
        )
    }

    @Test
    fun login(){
        val a = AuthApi()
            .auth()
            .login(LoginForm("test","testps"))
            .blockingFirst()


        println(a)

//        assertEquals()
    }
}