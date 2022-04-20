package com.test.composedemo.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.test.composedemo.model.entity.ArticleEntity

class TaskViewModel : ViewModel() {


    val studyDate by mutableStateOf("学习周期：2022.01.01-2022.12.31")
    var pointOfYear by mutableStateOf("10000")
        private set


    var pointsOfWeek by mutableStateOf(listOf(0.0, 2.0, 6.0, 9.5, 10.0, 15.0, 5.0))
        private set

    val week by mutableStateOf(listOf("02.05", "02.06", "02.07", "02.08", "02.09", "02.10", "今日"))


    fun updatePointOfYear(point: String) {
        pointOfYear = point
    }

}