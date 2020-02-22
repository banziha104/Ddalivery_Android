package com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signin

import android.os.Bundle
import android.widget.EditText
import androidx.lifecycle.ViewModelProviders
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.core.rx.activity.AutoClearedDisposable
import com.iyeongjoon.nicname.data.form.auth.LoginForm
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signup.SignUpActivity
import com.iyeongjoon.nicname.ddalivery.ui.activities.main.MainActivity
import com.iyeongjoon.nicname.domain.domain.db.entity.token.TokenEntity
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.view.focusChanges
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * 로그인 화면
 */
class SignInActivity : DaggerAppCompatActivity(), AnkoLogger {

    @Inject lateinit var viewModelFactory: SignInViewModelFactory
    private lateinit var viewModel: SignInViewModel
    private val disposable = AutoClearedDisposable(this)
    private val viewDisposables =
        AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)


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

        handleEditTextFocus(arrayOf(signInEditId, signInEditPassword))
        /***
         * 로그인 버튼 클릭
         */
        viewDisposables += signInBtnConfirm
            .clicks()
            .subscribe{
                viewDisposables += viewModel
                    .auth
                    .login(LoginForm(signInEditId.text.toString(), signInEditPassword.text.toString()))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe ({
                        info { "1" }
                        if (it.code == "OK" || it.data != null) {
                            viewDisposables += viewModel
                                .singleTokenStore
                                .subscribeOn(Schedulers.computation())
                                .observeOn(Schedulers.computation())
                                .subscribe({ db ->
                                    if (db.isEmpty()) {
                                        viewModel.localDatabase.tokenDao().insert(TokenEntity(1,it.data!!.token))
                                    }else{
                                        viewModel.localDatabase.tokenDao().update(TokenEntity(1,it.data!!.token))
                                    }
                                },{
                                    toast("로컬 데이터베이스에 접근할 수 없습니다")
                                })

                            moveToMainActivity()
                        } else {
                            toast(it.message)
                        }
                    }, {
                        toast("네트워크 에러입니다 관리자에게 문의해주세요.")
                        it.printStackTrace()
                    })
            }

        /***
         * 회원가입 버튼 클릭
         */

        viewDisposables += signInBtnSignUp
            .clicks()
            .subscribe({
                moveToSignUpActivity()
            }, {
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
    fun handleEditTextFocus(views: Array<EditText>) {
        views.forEach {
            it.apply {
                viewDisposables += focusChanges()
                    .subscribe {
                        background =
                            if (it) getDrawable(R.drawable.edit_text_background_onfocus) else getDrawable(R.drawable.edit_text_background)
                    }
            }
        }
    }
}
