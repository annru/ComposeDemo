package com.anzhixiang.sunflower.flow

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


@Composable
fun FlowTest() {

    val flowCount = flowTest1().collectAsState(0)

    Text(
        text = flowCount.value.toString(),
        modifier = Modifier.fillMaxSize(),
        fontSize = 30.sp,
        textAlign = TextAlign.Center
    )


}


fun flowTest1(): Flow<Int> = flow {
    for (i in 0..10) {
        delay(1000L)
        emit(i)
        Log.i("打印i-----", "$i")
    }
}


@Composable
@Preview(backgroundColor = 0x661155, showBackground = true, heightDp = 400)
fun FlowTestPreview() {
    FlowTest()
}