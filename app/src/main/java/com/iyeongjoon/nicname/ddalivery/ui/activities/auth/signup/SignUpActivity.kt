package com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signup

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.EditText
import androidx.lifecycle.ViewModelProviders
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.di.ui.dialogs.FindAddressDialog
import com.iyeongjoon.nicname.ddalivery.ex.plusAssign
import com.iyeongjoon.nicname.ddalivery.rx.AutoClearedDisposable
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.view.focusChanges
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_up.*
import javax.inject.Inject

class SignUpActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: SignUpViewModelFactory
    lateinit var viewModel: SignUpViewModel
    val disposable = AutoClearedDisposable(this)
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[SignUpViewModel::class.java]
        bind()
    }

    fun bind() {
        handleEditTextFocus(
            arrayOf(
                signUpEditId,
                signUpEditPs,
                signUpEditPsCofirm,
                signUpEditName,
                signUpEditPhone
            )
        )

        viewDisposables +=
            signBtnFindAddress.clicks()
                .subscribe({
                    val dialog = FindAddressDialog(this,::setAddress)
                    dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    dialog.show()
                }, {
                    it.printStackTrace()
                })



    }

    /**
     * 주소 세팅
     * @param address Array<String?> zipCode, address 순으로 넘어옮
     */
    fun setAddress(address: Array<String?>) {

        signUpTxtAddress.text = address[1]
    }

    /***
     * editText 포커싱 처리
     */
    fun handleEditTextFocus(views: Array<EditText>) {
        views
            .forEach {
                it.apply {
                    viewDisposables += focusChanges()
                        .subscribe {
                            background =
                                if (it) getDrawable(R.drawable.edit_text_background_onfocus) else getDrawable(
                                    R.drawable.edit_text_background
                                )
                        }
                }
            }
    }
}
