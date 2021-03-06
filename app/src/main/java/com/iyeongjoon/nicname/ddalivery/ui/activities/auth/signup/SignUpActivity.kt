package com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signup

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.core.rx.activity.AutoClearedDisposable
import com.iyeongjoon.nicname.data.form.auth.SignUpForm
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signin.SignInActivity
import com.iyeongjoon.nicname.ddalivery.ui.dialogs.FindAddressDialog
import com.iyeongjoon.nicname.ddalivery.utils.EditTextHandler
import com.jakewharton.rxbinding3.view.clicks
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

class SignUpActivity : DaggerAppCompatActivity(), AnkoLogger {

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

    private fun bind() {

        viewDisposables += viewModel.submitCheck
            .subscribe({
                it.forEach { if (!it.value) return@subscribe }
                signUpBtnSubmit.isEnabled = true
            }, {
                it.printStackTrace()
            })
        viewDisposables += signUpBtnFindAddress.clicks()
            .subscribe({
                val dialog = FindAddressDialog(this, ::setAddress)
                dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                dialog.show()
            }, {
                it.printStackTrace()
            })

        viewDisposables += signUpBtnSubmit
            .clicks()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (viewModel.zipCode == null) {
                    toast("우편번호가 잘못되었습니다. 주소를 다시 선택해 주세요").show()
                    return@subscribe
                }

                if (signUpEditPs.text.toString() != signUpEditPsConfirm.text.toString()) {
                    toast("비밀번호가 서로 일치하지 않습니다").show()
                    return@subscribe
                }

                disposable += viewModel
                    .auth
                    .signUp(
                        SignUpForm(
                            signUpEditId.text.toString(),
                            signUpEditPsConfirm.text.toString(),
                            signUpEditName.text.toString(),
                            signUpTxtAddress.text.toString(),
                            signUpEditAdressDetail.text.toString(),
                            viewModel.zipCode!!,
                            signUpEditPhone.text.toString()
                        )
                    )
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        if (it.code == "OK") {
                            toast("회원가입에 성공했습니다").show()
                            moveToSignIn()
                        } else {
                            if (it.message == "로그인 아이디가 중복되었습니다") toast("이미 존재하는 이메일입니다").show()
                            else toast("회원가입 오류입니다. 관리자에게 문의해주세요").show()
                        }
                    }, {
                        it.printStackTrace()
                        toast("네트워크 오류입니다. 관리자에게 문의해주세요").show()
                    })
            }, {
                it.printStackTrace()
            })

        EditTextHandler(viewDisposables,SignUpActivity@this,viewModel.submitCheck).handleEditTextFocusWithId(viewModel.editTextsAndRule)
    }

    /**
     * 주소 선택시 호출
     * @param address Array<String?> zipCode, address 순으로 넘어옮
     */
    protected fun setAddress(address: Array<String?>) {
        viewModel.submitCheck.value!!.also {
            it[signUpTxtAddress.id] = true
            viewModel.submitCheck.onNext(it)
        }
        viewModel.zipCode = address[0]
        signUpTxtAddress.text = address[1]
        signUpEditAdressDetail.isEnabled = true
    }


    private fun moveToSignIn() {
        startActivity<SignInActivity>()
        finish()
    }
}
