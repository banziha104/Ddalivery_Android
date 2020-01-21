package com.iyeongjoon.nicname.ddalivery.utils

import android.app.Activity
import android.content.Context
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.core.rx.AutoClearedDisposableContract
import com.iyeongjoon.nicname.core.rx.activity.AutoClearedDisposable
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ex.validation.checkWithEditText
import com.jakewharton.rxbinding3.view.focusChanges
import com.jakewharton.rxbinding3.widget.textChanges
import com.wajahatkarim3.easyvalidation.core.rules.BaseRule
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator
import io.reactivex.subjects.BehaviorSubject
import org.jetbrains.anko.find


class EditTextHandler(
    private val viewDisposables: AutoClearedDisposableContract,
    private val context: Activity,
    private val checker: BehaviorSubject<MutableMap<Int, Boolean>>
) {
    /***
     * editText 포커싱 처리
     */
    fun handleEditTextFocusWithId(pairs: Array<Pair<Int, Array<BaseRule>>>) {
        pairs.map { Pair<EditText, Array<BaseRule>>(context.findViewById(it.first), it.second) }
            .forEach { addRule(it) }
    }

    // 직접 EditText를 넘길때
    fun handleEditTextFocusWithEditText(pairs: Array<Pair<EditText, Array<BaseRule>>>) {
        pairs.forEach { addRule(it) }
    }


    fun addRule(pair: Pair<EditText, Array<BaseRule>>) {
        pair.run {
            viewDisposables += first.focusChanges().subscribe { isCorrect ->
                first.background = if (isCorrect) {
                    bindValidation(this)
                    context.getDrawable(R.drawable.edit_text_background_onfocus)
                } else {
                    context.getDrawable(R.drawable.edit_text_background)
                }
            }
        }
    }


    /***
     * 각 텍스트뷰에 유효성 검증
     * @param pair Pair<EditText, Array<BaseRule>>
     */
    private fun bindValidation(pair: Pair<EditText, Array<BaseRule>>) {
        pair.run {
            viewDisposables += first.textChanges()
                .subscribe({
                    val validator = first.validator()
                    pair.second.forEach { rule -> validator.addRule(rule) }
                    validator.checkWithEditText(context, first, checker)
                }, { throwable ->
                    throwable.printStackTrace()
                })
        }
    }
}