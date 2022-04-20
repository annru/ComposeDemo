package com.test.composedemo.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.test.composedemo.model.entity.ArticleEntity
import com.test.composedemo.model.entity.VideoEntity

class VideoViewModel : ViewModel() {


    var list = listOf(
        VideoEntity(
            title = "一起学习 Jetpack Compose 项目实战,一起学习 Jetpack Compose 项目实战.",
            type = "视频课程",
            duration = "00:30:00",
            imageUrl = "https://img95.699pic.com/xsj/2j/mm/za.jpg!/fw/700/watermark/url/L3hzai93YXRlcl9kZXRhaWwyLnBuZw/align/southeast"
        ),
        VideoEntity(
            title = "一起学习 Jetpack Compose 项目实战",
            type = "视频课程",
            duration = "00:30:00",
            imageUrl = "https://seopic.699pic.com/photo/50176/4849.jpg_wh1200.jpg"
        ),
        VideoEntity(
            title = "一起学习 Jetpack Compose 项目实战",
            type = "视频课程",
            duration = "00:30:00",
            imageUrl = "https://docs.bughub.icu/compose/assets/banner1.webp"
        ),
        VideoEntity(
            title = "一起学习 Jetpack Compose 项目实战,一起学习 Jetpack Compose 项目实战",
            type = "视频课程",
            duration = "00:30:00",
            imageUrl = "https://docs.bughub.icu/compose/assets/banner1.webp"
        ),
        VideoEntity(
            title = "一起学习 Jetpack Compose 项目实战",
            type = "视频课程",
            duration = "00:30:00",
            imageUrl = "https://seopic.699pic.com/photo/50167/4635.jpg_wh1200.jpg"
        ),
        VideoEntity(
            title = "一起学习 Jetpack Compose 项目实战",
            type = "视频课程",
            duration = "00:30:00",
            imageUrl = "https://docs.bughub.icu/compose/assets/banner1.webp"
        )

    )
        private set
}