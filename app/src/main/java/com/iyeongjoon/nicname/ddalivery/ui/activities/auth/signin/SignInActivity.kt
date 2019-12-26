package com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signin

import androidx.lifecycle.ViewModelProviders
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.iyeongjoon.nicname.data.form.auth.LoginForm
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ex.plusAssign
import com.iyeongjoon.nicname.ddalivery.rx.AutoClearedDisposable
import com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signup.SignUpActivity
import com.iyeongjoon.nicname.ddalivery.ui.activities.main.MainActivity
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.view.focusChanges
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject
import org.jetbrains.anko.info
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.util.*

/**
 * 로그인 화면
 */
class SignInActivity : DaggerAppCompatActivity(), AnkoLogger {

    @Inject
    lateinit var viewModelFactory: SignInViewModelFactory
    lateinit var viewModel: SignInViewModel
    val disposable = AutoClearedDisposable(this)
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        lifecycle += viewDisposables
        lifecycle += disposable
        viewModel = ViewModelProviders.of(this, viewModelFactory)[SignInViewModel::class.java]
        bind()

    }

    /**
     * 뷰 바인딩
     */
    fun bind() {

        handleEditTextFocus(arrayOf(signInEditId,signInEditPassword))
        /***
         * 로그인 버튼 클릭
         */
        disposable += signInBtnConfirm
            .clicks()
            .subscribe({
                disposable += viewModel
                    .authApi
                    .auth()
                    .login(
                        LoginForm(
                            signInEditId.text.toString(),
                            signInEditPassword.text.toString()
                        )
                    )
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe{
                        if (it.code == "OK") {
                            moveToMainActivity()
                        } else {
                            toast(it.message)
                        }
                    }
            },{
                it.printStackTrace()
            })

        /***
         * 회원가입 버튼 클릭
         */

        disposable += signInBtnSignUp
            .clicks()
            .subscribe({
                moveToSignUpActivity()
            },{
                it.printStackTrace()
            })
    }

    fun moveToMainActivity() {
        startActivity<MainActivity>()
        finish()
    }

    fun moveToSignUpActivity() {
        startActivity<SignUpActivity>()
        finish()
    }

    /***
     * editText 포커싱 처리
     */
    fun handleEditTextFocus(views : Array<EditText>){
        views
            .forEach {
                it.apply {
                    disposable += focusChanges()
                        .subscribe {
                            background = if (it) getDrawable(R.drawable.edit_text_background_onfocus) else getDrawable(R.drawable.edit_text_background)
                        }
                }
            }
    }
}
