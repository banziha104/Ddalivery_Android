package com.iyeongjoon.nicname.ddalivery.ex.validation

import android.content.Context
import android.widget.EditText
import com.iyeongjoon.nicname.ddalivery.R
import com.wajahatkarim3.easyvalidation.core.Validator
import io.reactivex.subjects.BehaviorSubject

fun Validator.checkWithEditText(
    context: Context,
    editText: EditText,
    checker: BehaviorSubject<MutableMap<Int, Boolean>>
) {
    checker.value!!.let {
        this.addErrorCallback { _ ->
            it[editText.id] = false
            checker.onNext(it)
            editText.background = context.getDrawable(R.drawable.edit_text_background_validation_fail)
        }.addSuccessCallback {
            it[editText.id] = true
            checker.onNext(it)
            editText.background = context.getDrawable(R.drawable.edit_text_background_validation_success)
        }.check()
    }
}