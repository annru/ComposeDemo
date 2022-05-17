package com.test.composedemo.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog


@Composable
fun DialogCommon(onDismiss: () -> Unit) {

    Dialog(onDismissRequest = onDismiss) {
        Text(text = "这是一段描述dialog的文本")
    }
}


