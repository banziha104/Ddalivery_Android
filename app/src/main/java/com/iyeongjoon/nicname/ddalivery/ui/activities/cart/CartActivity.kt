package com.iyeongjoon.nicname.ddalivery.ui.activities.cart

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.core.rx.activity.AutoClearedDisposable
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.cart.CartAdapter
import com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.cart.CartAdapterViewModel
import com.jakewharton.rxbinding3.view.clicks
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_cart.*
import javax.inject.Inject

class CartActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: CartViewModelFactory
    private lateinit var viewModel: CartViewModel
    private val disposables = AutoClearedDisposable(this)
    private val viewDisposables =
        AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)
    lateinit var cartAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        lifecycle += disposables
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[CartViewModel::class.java]
        bind()
    }

    private fun bind() {
        viewDisposables += viewModel
            .readCartData
            .subscribe({
                cartAdapter = CartAdapter(
                    CartAdapterViewModel(
                        this,
                        ArrayList(it),
                        disposables,
                        viewModel.localDatabase
                    )
                )
                cartRecyclerView.apply {
                    adapter = cartAdapter
                    layoutManager = LinearLayoutManager(context)
                }
            }, {

            })

        viewDisposables += cartBtnConfirm
            .clicks()
            .subscribe({
                //TODO : 바로 요청하기
            }, {
                it.printStackTrace()
            })
    }
}
