package com.test.composedemo.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView


@Composable
fun WebView() {


    AndroidView(factory = { context -> android.webkit.WebView(context) }) { view ->
        view.loadUrl("https://www.baidu.com")
    }


}


