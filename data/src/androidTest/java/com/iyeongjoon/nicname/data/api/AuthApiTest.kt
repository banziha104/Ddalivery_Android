package com.iyeongjoon.nicname.data.api

import android.support.test.runner.AndroidJUnit4
import com.iyeongjoon.nicname.data.api.auth.AuthApi
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
    fun getTest(){

        val api = AuthApi().getTest().getTest().blockingFirst()
        print(api)
        assertEquals(api.data,"OK")
    }
}