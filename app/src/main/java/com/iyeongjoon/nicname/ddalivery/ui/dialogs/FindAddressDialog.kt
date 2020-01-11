package com.iyeongjoon.nicname.ddalivery.ui.dialogs

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import androidx.appcompat.app.AppCompatActivity
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.core.rx.activity.AutoClearedDisposable
import com.iyeongjoon.nicname.ddalivery.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.dialog_find_address.*
import org.jetbrains.anko.AnkoLogger


/**
 *
 * @property activity AppCompatActivity
 * @property driver PublishSubject<(kotlin.Array<kotlin.String?>..kotlin.Array<kotlin.String?>?)>
 * @property disposable AutoClearedDisposable
 * @property viewDisposables AutoClearedDisposable
 * @constructor
 */
class FindAddressDialog(val activity: AppCompatActivity, val setTxtAddress : (Array<String?>) -> Unit) : Dialog(activity), View.OnClickListener,
    AnkoLogger {

    val driver = PublishSubject.create<Array<String?>>()

    val disposable =
        AutoClearedDisposable(
            activity
        )
    val viewDisposables =
        AutoClearedDisposable(
            lifecycleOwner = activity,
            alwaysClearOnStop = false
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_find_address)
        bindWebView()
        viewDisposables += driver
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                setTxtAddress(it)
                dismiss()
            }, {
                it.printStackTrace()
            })

    }

    /**
     * 웹뷰 세팅
     */
    @SuppressLint("SetJavaScriptEnabled")
    fun bindWebView() {
        findAddressDiaWebView.apply {
            settings.javaScriptEnabled = true
            settings.javaScriptCanOpenWindowsAutomatically = true
            webChromeClient = WebChromeClient()
            addJavascriptInterface(AndroidBridge(), "Ddalivery")
            loadUrl("http://ec2-54-180-97-228.ap-northeast-2.compute.amazonaws.com:5000/")
        }
    }


    override fun onClick(v: View?) {

    }

    inner class AndroidBridge : AnkoLogger {
        /**
         * 주소 선택시 콜백
         * @param zipCode String?
         * @param address String?
         * @param arg3 String?
         */
        @JavascriptInterface
        fun setAddress(zipCode: String?, address: String?, arg3: String?) {
            driver.onNext(arrayOf(zipCode, address, arg3))
        }
    }
}