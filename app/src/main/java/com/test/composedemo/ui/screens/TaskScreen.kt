package com.test.composedemo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.test.composedemo.ui.components.ChartView
import com.test.composedemo.ui.components.CircleRing
import com.test.composedemo.ui.components.DialogCommon
import com.test.composedemo.ui.viewmodel.TaskViewModel


@Composable
fun TaskScreen(taskVM: TaskViewModel = viewModel()) {

    var showing by remember {
        mutableStateOf(false)
    }


    var boxWidth: Int

    with(LocalConfiguration.current) {
        boxWidth = screenWidthDp / 2
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF149EE7),
                        Color.White
                    )
                )
            )
    ) {
        //标题
        androidx.compose.material.TopAppBar(title = {
            Text(
                text = "学习任务",
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }, elevation = 0.dp)

        //学习周期
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            item {
                Text(
                    text = taskVM.studyDate,
                    fontSize = 12.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }

            //学习进度
            item {
                Box(
                    modifier = Modifier
                        .height(boxWidth.dp)
                        .padding(top = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    //圆环
                    CircleRing(boxWidth)

                    //进度数据
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(buildAnnotatedString {
                            append(taskVM.pointOfYear)
                            withStyle(SpanStyle(fontSize = 12.sp)) {
                                append("分")
                            }
                        }, fontSize = 36.sp, color = Color.White)

                        Text(text = "学年积分", fontSize = 12.sp, color = Color.White)
                    }
                }
            }

            item {
                //学习明细
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-50).dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column() {
                        Text(text = "13500", fontSize = 16.sp, color = Color.White)
                        Text(text = "学年规定积分", fontSize = 12.sp, color = Color.White)
                    }
                    Column() {
                        Text(text = "3500", fontSize = 16.sp, color = Color.White)
                        Text(text = "还差", fontSize = 12.sp, color = Color.White)
                    }
                }
            }

            //学习明细
            item {
                Column(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                topStart = 8.dp,
                                topEnd = 8.dp
                            )
                        )
                        .background(Color.White)
                        .padding(16.dp)
                        .fillMaxSize()
                ) {
                    Text(text = "学习明细", fontSize = 16.sp, color = Color(0xFF333333))
                    Text(text = "最近一周学习情况", fontSize = 14.sp, color = Color(0xFF999999))

                    ChartView(taskVM)

                    Row() {
                        taskVM.week.forEach {
//                            val bg = if (index % 2 == 1) Color.Blue else Color.Yellow
                            Text(
                                text = it,
                                fontSize = 12.sp,
                                color = Color(0xFF149EE7),
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    //今日任务提醒
                    Text(
                        text = "今日获得0积分",
                        color = Color(0xFF149EE7),
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0x33149EE7))
                            .padding(8.dp)
                            .fillMaxWidth()
                    )

                    //
                    Button(onClick = {
//                        taskVM.updatePointOfYear("9000")

                        if (!showing) {

//                                DialogCommon {
//                                    showing = !showing
//                                }


                        }
                    }) {
                        Text(text = "弹出对话卡")
                    }

                    TextButton(onClick = { taskVM.updatePointOfYear("7000") }) {
                        Text(text = "哈哈")
                    }
                }
            }
        }
    }
}


@Composable
fun TaskScreenPreview() {
    TaskScreen()
}

