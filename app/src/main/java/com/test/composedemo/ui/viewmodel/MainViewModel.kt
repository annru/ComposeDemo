package com.test.composedemo.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.test.composedemo.model.entity.Category
import com.test.composedemo.model.entity.SwiperEntity

class MainViewModel : ViewModel() {


    val categories by mutableStateOf(
        listOf(
            Category("思想政治"),
            Category("法律法规"),
            Category("超越自我"),
            Category("诚信品质")
        )
    )

    var categoryIndex by mutableStateOf(0)
        private set

    fun updateCategoryIndex(index: Int) {
        categoryIndex = index
    }


    var types by mutableStateOf(listOf("相关课程", "视频资讯"))

    var showArticleList by mutableStateOf(true)
        private set


    var typeIndex by mutableStateOf(0)
        private set

    fun updateTypeIndex(index: Int) {
        typeIndex = index
        showArticleList = typeIndex == 0
    }

    val swiperData = listOf(
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner1.webp"),
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner2.webp"),
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner3.webp"),
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner4.jpg"),
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner5.jpg")
    )

    val notifications = listOf("人社部向疫情防控期", "湖北黄冈新冠肺炎患者治愈病例破千连续批签啊哈哈哈妈卖批", "上海4日新增确认病例超过一万人，首次突破一万")
}