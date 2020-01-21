package com.iyeongjoon.nicname.ddalivery.ui.dialogs.Item

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.EditText
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.ddalivery.GlideApp
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ex.imageUrl
import com.iyeongjoon.nicname.ddalivery.ex.validation.checkWithEditText
import com.iyeongjoon.nicname.ddalivery.utils.EditTextHandler
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.view.focusChanges
import com.jakewharton.rxbinding3.widget.textChanges
import com.wajahatkarim3.easyvalidation.core.rules.BaseRule
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.dialog_item.*

class ItemDialog(var viewModel: ItemDialogViewModel) : Dialog(viewModel.context) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_item)
        resizeView()
        bind()
    }

    private fun bind() {
        viewModel.run {
            // TODO : editTextHandler 손보기
            EditTextHandler(disposable,context,checker).handleEditTextFocusWithEditText(arrayOf(Pair(itemDialogEdit,viewModel.rules)))
            disposable += itemDialogBackground.clicks().subscribe { dismiss() }
            product.apply {
                itemDialogTxtTitle.text = productName

                GlideApp
                    .with(context)
                    .load(image.imageUrl())
                    .into(itemDialogImg)
            }
        }
    }

    private fun resizeView() = itemDialogContainer.layoutParams.run {
        height = viewModel.height
        width = viewModel.width
    }
}