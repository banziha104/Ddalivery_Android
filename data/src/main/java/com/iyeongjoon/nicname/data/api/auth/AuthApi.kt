package com.iyeongjoon.nicname.data.api.auth

import com.iyeongjoon.nicname.data.api.ApiBase

class AuthApi : ApiBase(){
    fun auth() = createApi(AuthApiContract::class.java)
}