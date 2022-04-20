package com.test.composedemo.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.composedemo.model.entity.ArticleEntity


@Composable
fun CircleRing(boxWidth: Int) {

    val strokeWidth = 30f

    Canvas(modifier = Modifier.size(boxWidth.dp)) {

        drawArc(
            Color(0, 0, 0, 33),
            startAngle = 160f,
            sweepAngle = 220f,
            useCenter = false,
            style = Stroke(strokeWidth, cap = StrokeCap.Round)
        )

        drawArc(
            Color.White,
            startAngle = 160f,
            sweepAngle = 110f,
            useCenter = false,
            style = Stroke(strokeWidth, cap = StrokeCap.Round)
        )

    }

}


