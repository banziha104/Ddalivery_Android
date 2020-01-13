package com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signin

import android.content.Context
import androidx.lifecycle.ViewModel
import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class SignInViewModel(val authApi: AuthApi,
                      val localDatabase: LocalDatabase
) : ViewModel(), AnkoLogger{

}