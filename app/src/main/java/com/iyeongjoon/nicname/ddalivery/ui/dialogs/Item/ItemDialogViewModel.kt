package com.iyeongjoon.nicname.ddalivery.ui.dialogs.Item

import android.app.Activity
import com.iyeongjoon.nicname.core.rx.fragment.AutoClearedDisposable
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase
import com.iyeongjoon.nicname.domain.domain.api.entity.product.Content
import com.wajahatkarim3.easyvalidation.core.rules.NonEmptyRule
import com.wajahatkarim3.easyvalidation.core.rules.ValidNumberRule
import io.reactivex.subjects.BehaviorSubject
import org.jetbrains.anko.displayMetrics


class ItemDialogViewModel(
    val product : Content,
    val context: Activity,
    val disposable: AutoClearedDisposable,
    val localDatabase: LocalDatabase
) {
    val width = (context.displayMetrics.widthPixels * 0.75).toInt()
    val height = (context.displayMetrics.heightPixels * 0.8).toInt()
    val checker = BehaviorSubject.createDefault<MutableMap<Int, Boolean>>(mutableMapOf(R.id.itemDialogEdit to false))
    val rules  = arrayOf(NonEmptyRule(),ValidNumberRule())
}