package com.iyeongjoon.nicname.ddalivery.ui.dialogs.homeItem

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.ddalivery.R
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.dialog_home_item.*

class HomeItemDialog(var viewModel: HomeItemDialogViewModel) : Dialog(viewModel.context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_home_item)
        resizeView()
        bind()
    }

    private fun bind() {
        viewModel.disposable += homeDialogBackground.clicks().subscribe { dismiss() }
    }

    private fun resizeView() = homeDialogContainer.layoutParams.run {
        height = viewModel.heigth
        width = viewModel.width
    }


}