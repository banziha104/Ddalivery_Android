package com.iyeongjoon.nicname.ddalivery.ui.dialogs.homeItem

import android.app.Activity
import android.content.Context
import com.iyeongjoon.nicname.core.rx.fragment.AutoClearedDisposable
import org.jetbrains.anko.displayMetrics


class HomeItemDialogViewModel(val context: Context,val disposable: AutoClearedDisposable) {
    val width = (context.displayMetrics.widthPixels * 0.75).toInt()
    val heigth = (context.displayMetrics.heightPixels * 0.8).toInt()

}