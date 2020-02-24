package com.iyeongjoon.nicname.ddalivery.ui.activities.cart

import android.location.Location
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.auth0.android.jwt.JWT
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.core.rx.activity.AutoClearedDisposable
import com.iyeongjoon.nicname.core.utils.JWTUtils
import com.iyeongjoon.nicname.data.form.order.OrderForm
import com.iyeongjoon.nicname.data.form.order.OrderGroupForm
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.cart.CartAdapter
import com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.cart.CartAdapterViewModel
import com.jakewharton.rxbinding3.view.clicks
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.Singles
import kotlinx.android.synthetic.main.activity_cart.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import javax.inject.Inject

class CartActivity : DaggerAppCompatActivity() , AnkoLogger{
    @Inject
    lateinit var viewModelFactory: CartViewModelFactory
    private lateinit var viewModel: CartViewModel
    private val disposables = AutoClearedDisposable(this)
    private val viewDisposables =
        AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)
    lateinit var cartAdapter: CartAdapter
    lateinit var location: Location

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
                viewDisposables +=
                    Singles.zip(
                        viewModel.readCartData,
                        viewModel.loadToken
                    ) { cart, token -> cart to token }
                        .subscribe({ (cart, token) ->
                            val userToken = JWT(token[0].token)
                            val id = userToken.getClaim("accountId").asInt()
                            val name = userToken.getClaim("name").asString()
                            val address = userToken.getClaim("address").asString()

                            if (id != null && name != null && address != null) {
                                viewModel.orderCreate(
                                    OrderGroupForm(
                                        id,
                                        name,
                                        address,
                                        location.latitude,
                                        location.longitude,
                                        cart.map { OrderForm.from(it) })
                                ).subscribe {
                                    viewModel.saveOrderGroup(it.data!!)
                                }
                            }else{
                                runOnUiThread { toast("카트정보가 없습니다").show() }
                            }
                        }, {
                            it.printStackTrace()
                        })
            }, {
                it.printStackTrace()
            })
    }

    fun bindLocation() {
        viewDisposables += viewModel
            .locationEvent
            .getLocationObserver()
            .subscribe { location = it }
    }


}
