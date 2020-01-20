package com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signup

import androidx.lifecycle.ViewModel
import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.ddalivery.R
import com.wajahatkarim3.easyvalidation.core.rules.*
import io.reactivex.subjects.BehaviorSubject
import org.jetbrains.anko.AnkoLogger

class SignUpViewModel(val authApi: AuthApi) : ViewModel(),AnkoLogger{


    var zipCode : String? = null

    /***
     * first : EditText
     * second : 각 뷰에 해당하는 유효성 검증 룰
     */
    val editTextsAndRule =
        arrayOf(
            Pair(R.id.signUpEditId, arrayOf(MinLengthRule(8), EmailRule(), NonEmptyRule())),
            Pair(R.id.signUpEditPs, arrayOf(MinLengthRule(8), MaxLengthRule(20), NonEmptyRule())),
            Pair(R.id.signUpEditPsConfirm,arrayOf(MinLengthRule(8), MaxLengthRule(20), NonEmptyRule())),
            Pair(R.id.signUpEditName,arrayOf(MinLengthRule(2),NonEmptyRule())),
            Pair(R.id.signUpEditPhone, arrayOf(MinLengthRule(8), MaxLengthRule(20), NonEmptyRule(),OnlyNumbersRule())),
            Pair(R.id.signUpEditAdressDetail,arrayOf(MinLengthRule(2), MaxLengthRule(20), NonEmptyRule()))
        )

    var submitCheck = BehaviorSubject.createDefault<MutableMap<Int,Boolean>>(
        mutableMapOf(
            R.id.signUpEditId to false,
            R.id.signUpEditPs to false,
            R.id.signUpEditPsConfirm to false,
            R.id.signUpEditName to false,
            R.id.signUpEditPhone to false,
            R.id.signUpTxtAddress to false,
            R.id.signUpEditAdressDetail to false
            )
    )


}