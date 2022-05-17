package com.test.composedemo.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.composedemo.R


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TestScreen() {


    var name by remember {
        mutableStateOf("")
    }

    var visibility by remember {
        mutableStateOf(false)
    }



    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    ) {


        AnimatedVisibility(visible = visibility, enter = scaleIn(), exit = scaleOut()) {
            Image(painter = painterResource(id = R.mipmap.login_bg), contentDescription = null)
        }


        Button(onClick = { visibility = !visibility }) {
            val value = if (visibility) "隐藏" else "显示"
            Text(text = value)
        }


    }

}


@Composable
@Preview
fun TestScreenPreview() {
//    TestScreen()
    TestProvider()
}

@Composable
fun TestProvider() {
    Column() {
        Text(text = "透明度测试1--------")
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(text = "透明度测试2--------")
            Text(text = "透明度测试3--------")
        }
        val resources = LocalContext.current.resources
        val s = resources.getQuantityString(R.plurals.fruit_title, 3)
        Text(text = s)
    }
}

