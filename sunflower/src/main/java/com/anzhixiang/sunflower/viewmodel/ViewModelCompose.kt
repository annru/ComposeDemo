package com.anzhixiang.sunflower.viewmodel

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel


/**
 * Compose中使用ViewModel
 */

@SuppressLint("UnrememberedMutableState")
@Composable
fun ViewModelCompose() {

    val viewModel: OneViewModel = viewModel()

    val count by viewModel.count.observeAsState(0)


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = count.toString())
        Button(onClick = { viewModel.onCountChanged(count + 2) }) {
            Text(text = "add count")
        }
    }
}


@Composable
@Preview(backgroundColor = 0x661155, showBackground = true, heightDp = 400)
fun ViewModelComposePreview() {
    ViewModelCompose()
}