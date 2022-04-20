package com.test.composedemo.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.composedemo.ui.viewmodel.TaskViewModel


@Composable
fun ChartView(taskVM: TaskViewModel) {


    val canvasWidth = LocalConfiguration.current.screenWidthDp - 8 * 2


    val rowCount = 5
    val rowHeight = 24
    val circleRadius = 2.5

    val perY = 8

    val canvasHeight = rowCount * rowHeight + circleRadius * 2

    val averageOfWidth = canvasWidth / 7


    Canvas(modifier = Modifier.size(canvasWidth.dp, canvasHeight.dp)) {
        for (index in 0..rowCount) {
            val y = (index * rowHeight + circleRadius).dp.toPx()
            drawLine(
                start = Offset(0f, y),
                end = Offset(size.width, y),
                color = Color(0xFFEEEEEE),
                strokeWidth = 2.5f
            )
        }

        for (index in 0 until taskVM.pointsOfWeek.count()) {
            val circleCenter =
                Offset(
                    (averageOfWidth * index + averageOfWidth / 2).dp.toPx(),
                    (rowHeight * rowCount - taskVM.pointsOfWeek[index] * perY + circleRadius).dp.toPx()
                )
            drawCircle(
                color = Color(0xFF149EE7),
                radius = circleRadius.dp.toPx(),
                center = circleCenter,
                style = Stroke(width = 5f)
            )

            if (index < taskVM.pointsOfWeek.count() - 1) {
                val nextPointOffset = Offset(
                    (averageOfWidth * (index + 1) + averageOfWidth / 2).dp.toPx(),
                    (rowHeight * rowCount - taskVM.pointsOfWeek[index + 1] * perY + circleRadius).dp.toPx()
                )

                drawLine(
                    color = Color(0xFF149EE7),
                    start = circleCenter,
                    end = nextPointOffset,
                    strokeWidth = 5f
                )
            }
        }
    }
}


