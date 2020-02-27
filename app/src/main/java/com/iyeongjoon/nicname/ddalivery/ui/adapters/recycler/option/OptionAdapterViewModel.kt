package com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.option

import android.content.Context

class OptionAdapterViewModel(
    val context: Context
) {
    val options: Array<Pair<String, Int>> = arrayOf(
        "정보 수정" to 1,
        "기타" to 2
    )

    val size: Int
        get() = options.size
}