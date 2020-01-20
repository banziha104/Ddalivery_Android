package com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signin

import androidx.lifecycle.ViewModel
import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase
import org.jetbrains.anko.AnkoLogger

class SignInViewModel(val authApi: AuthApi,
                      val localDatabase: LocalDatabase
) : ViewModel(), AnkoLogger{

}