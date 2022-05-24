package com.anzhixiang.sunflower.effect.sample

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun DisposableEffectSample() {

    var addBackCallback by remember {
        mutableStateOf(false)
    }

    Row() {
        Switch(checked = addBackCallback, onCheckedChange = { addBackCallback = !addBackCallback })
        Text(text = if (addBackCallback) "add Back Call Back" else "Not add Back call Back")
    }


}


@Composable
@Preview
fun DisposableEffectSamplePreview() {
    RememberUpdateStateSample()
}



