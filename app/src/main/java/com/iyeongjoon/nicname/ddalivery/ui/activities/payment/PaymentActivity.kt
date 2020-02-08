package com.iyeongjoon.nicname.ddalivery.ui.activities.payment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.core.rx.activity.AutoClearedDisposable
import com.iyeongjoon.nicname.ddalivery.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class PaymentActivity : DaggerAppCompatActivity() {
    
    @Inject lateinit var viewModelFactory: PaymentViewModelFactory
    private lateinit var viewModel : PaymentViewModel
    private val disposables = AutoClearedDisposable(this)
    private val viewDisposables = AutoClearedDisposable(lifecycleOwner = this,alwaysClearOnStop = false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        lifecycle += disposables
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[PaymentViewModel::class.java]

    }
}
