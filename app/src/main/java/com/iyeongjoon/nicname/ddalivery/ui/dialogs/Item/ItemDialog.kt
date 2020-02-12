package com.iyeongjoon.nicname.ddalivery.ui.dialogs.Item

import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.view.Window
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.ddalivery.GlideApp
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ex.imageUrl
import com.iyeongjoon.nicname.ddalivery.utils.EditTextHandler
import com.iyeongjoon.nicname.domain.domain.db.entity.cart.CartEntity
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.dialog_item.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class ItemDialog(var viewModel: ItemDialogViewModel) : Dialog(viewModel.context), AnkoLogger {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_item)
        resizeView()
        bind()
    }

    private fun bind() {
        viewModel.let { vm ->
            EditTextHandler(vm.disposable, vm.context, vm.checker).handleEditTextFocusWithEditText(
                arrayOf(Pair(itemDialogEdit, viewModel.rules))
            )

            vm.disposable += itemDialogBackground.clicks().subscribe { dismiss() }
            vm.product.apply {

                itemDialogTxtTitle.text = productName
                itemDialogTxtPrice.text = price.toString() + "원"
                itemDialogTxtSeller.text = seller.sellerName
                itemDialogTxtDescription.text = description
                itemDialogTxtAddress.text = seller.address

                GlideApp
                    .with(context)
                    .load(image.imageUrl())
                    .into(itemDialogImg)
            }
            vm.disposable += itemDialogBtnPlus.clicks()
                .subscribe { addQuantityButtonHandler("PLUS") }

            vm.disposable += itemDialogBtnMinus.clicks()
                .subscribe { addQuantityButtonHandler("MINUS") }


//            runOnIoScheduler {
//                vm.localDatabase.cartDao().deleteAll()
//            }


            vm.disposable += itemDialogBtnSubmit.clicks()
                .observeOn(Schedulers.computation())
                .subscribe({
                    vm.localDatabase.cartDao().findAllToSingle()
                        .subscribe({
                            vm.product.apply {
                                val sameProductList = it.filter { it.productId == productId }
                                if (sameProductList.isNotEmpty()){
                                    info { "not empty" }
                                    vm.localDatabase.cartDao().update(
                                        CartEntity(
                                            sameProductList[0].id,
                                            category.categoryName,
                                            description,
                                            image,
                                            price,
                                            productId,
                                            productName,
                                            sameProductList[0].quantity + itemDialogEdit.text.toString().toInt())
                                    )
                                }else{
                                    info { "empty" }
                                    vm.localDatabase.cartDao().insert(
                                        CartEntity(null,
                                            category.categoryName,
                                            description,
                                            image,
                                            price,
                                            productId,
                                            productName,
                                            itemDialogEdit.text.toString().toInt())
                                    )
                                }
                            }
                            vm.context.runOnUiThread{
                                viewModel.context.toast("카트에 ${viewModel.product.productName}이 ${itemDialogEdit.text.toString().toInt()}개 담겼습니다")
                                dismiss()
                            }
                        },{

                        })

                }, {
                    it.printStackTrace()
                })
        }
    }

    private fun resizeView() = itemDialogContainer.layoutParams.run {
        height = viewModel.height
        width = viewModel.width
    }

    private fun addQuantityButtonHandler(type: String) {
        try {
            var text = itemDialogEdit.text.toString().toInt()
            itemDialogEdit.text = Editable.Factory.getInstance().newEditable(
                when (type) {
                    "PLUS" -> (++text).toString()
                    "MINUS" -> {
                        if (text - 1 > 0) (--text).toString()
                        else text.toString()
                    }
                    else -> text.toString()
                }
            )
        } catch (e: NumberFormatException) {
            e.printStackTrace()
            viewModel.context.toast("수량에는 숫자만 입력 가능합니다").show()
        }
    }
}