package com.iyeongjoon.nicname.data.form.auth

data class SignUpForm(
    var loginId: String,
    var loginPassword: String,
    var name: String,
    var address: String,
    var detailAddress: String,
    var zipCode: String,
    var phoneNumber: String)