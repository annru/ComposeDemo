package com.anzhixiang.sunflower.effect.sample

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay


@Composable
fun RememberUpdateStateSample() {
    val onTimeOut1: () -> Unit = { Log.d("ning", "landing timeout 1.") }
    val onTimeOut2: () -> Unit = { Log.d("ning", "landing timeout 2.") }

    val changeOnTimeOutState = remember { mutableStateOf(onTimeOut1) }


    Column() {
        Button(onClick = {
            if (changeOnTimeOutState.value == onTimeOut1) {
                changeOnTimeOutState.value = onTimeOut2
            } else {
                changeOnTimeOutState.value = onTimeOut1
            }
        }) {
            Text(text = "choose onTimeOut${if (changeOnTimeOutState.value == onTimeOut1) 1 else 2}")
        }

        LandingScreen(changeOnTimeOutState.value)
    }

}


@Composable
fun LandingScreen(onTimeOut: () -> Unit) {
    val currentTimeOut by rememberUpdatedState(newValue = onTimeOut)
    LaunchedEffect(Unit) {
        Log.d("ning", "LaunchedEffect")
        repeat(10) {
            delay(1000L)
            Log.d("ning", "delay ${it + 1}s")
        }

        currentTimeOut()
    }
}


@Composable
@Preview
fun RememberUpdateStateSamplePreview() {
    RememberUpdateStateSample()
}



