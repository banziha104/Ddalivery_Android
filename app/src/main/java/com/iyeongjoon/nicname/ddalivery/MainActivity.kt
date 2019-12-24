package com.iyeongjoon.nicname.ddalivery

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.iyeongjoon.nicname.domain.Abc

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        print(Abc().getThis())
    }
}
