package com.iyeongjoon.nicname.data.api.auth

import com.iyeongjoon.nicname.data.api.ApiBase

class AuthApi : ApiBase(){
    fun getTest() = makeModel(AuthApiContract::class.java)
}