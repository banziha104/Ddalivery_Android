package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.user

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.core.rx.fragment.AutoClearedDisposable

import com.iyeongjoon.nicname.ddalivery.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class UserFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: UserViewModelFactory
    private lateinit var viewModel: UserViewModel
    private val disposables = AutoClearedDisposable(this)
    private val viewDisposables = AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        lifecycle += disposables
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[UserViewModel::class.java]

    }

}
