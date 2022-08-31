package com.anzhixiang.sunflower.animation

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@SuppressLint("UnrememberedMutableState")
@Composable
fun EasyAnimation() {


    val expend = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .size(720.dp)
            .padding(10.dp)
    ) {

        Text(
            text = "天青色等烟雨 而我在等你\n" +
                    "炊烟袅袅升起 隔江千万里\n" +
                    "在瓶底书汉隶仿前朝的飘逸\n" +
                    "就当我为遇见你伏笔\n" +
                    "天青色等烟雨 而我在等你\n" +
                    "月色被打捞起 晕开了结局\n" +
                    "如传世的青花瓷自顾自美丽\n" +
                    "周杰伦《青花瓷》\n" +
                    "周杰伦《青花瓷》\n" +
                    "你眼带笑意\n" +
                    "色白花青的锦鲤跃然于碗底\n" +
                    "临摹宋体落款时却惦记着你\n" +
                    "你隐藏在窑烧里千年的秘密\n" +
                    "极细腻犹如绣花针落地\n" +
                    "帘外芭蕉惹骤雨门环惹铜绿\n" +
                    "而我路过那江南小镇惹了你\n" +
                    "在泼墨山水画里\n" +
                    "你从墨色深处被隐去\n" +
                    "天青色等烟雨 而我在等你",
            fontSize = 16.sp, textAlign = TextAlign.Justify, overflow = TextOverflow.Ellipsis,
            modifier = Modifier.animateContentSize(),
            maxLines = if (expend.value) Int.MAX_VALUE else 2
        )

        Text(if (expend.value) "收起" else "全文", color = Color.Blue, modifier = Modifier.clickable {
            expend.value = !expend.value
        })


    }

}


@Composable
@Preview(backgroundColor = 0x661155, showBackground = true, heightDp = 400)
fun EasyAnimationPreview() {
    EasyAnimation()
}