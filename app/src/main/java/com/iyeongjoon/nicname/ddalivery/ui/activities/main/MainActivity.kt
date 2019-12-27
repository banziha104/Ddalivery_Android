package com.iyeongjoon.nicname.ddalivery.ui.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iyeongjoon.nicname.ddalivery.R
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.AnkoLogger

class MainActivity : DaggerAppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
