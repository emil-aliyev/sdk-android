package com.skytech

import android.net.Uri
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import java.lang.ref.WeakReference

class AppChromeClient(private val fragmentWeakReference: WeakReference<SkyTechActivity>) :
    WebChromeClient() {
    private var openFileCallback: ValueCallback<Array<Uri>>? = null

    override fun onShowFileChooser(
        webView: WebView?,
        filePathCallback: ValueCallback<Array<Uri>>?,
        fileChooserParams: FileChooserParams?
    ): Boolean {
        if (filePathCallback == null) {
            return (super.onShowFileChooser(webView, filePathCallback, fileChooserParams))
        }
        openFileCallback = filePathCallback
        val webViewFragment = fragmentWeakReference.get() ?: return false
        webViewFragment.launchGetMultipleContents("*/*")

        return true
    }

    fun receiveFileCallback(result: Array<Uri>) {
        openFileCallback?.onReceiveValue(result)
        openFileCallback = null
    }
}