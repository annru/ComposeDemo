package com.test.composedemo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TopAppBar(content: @Composable () -> Unit) {
    Row(
        modifier = Modifier
            .background(
                Brush.linearGradient(
                    listOf(MaterialTheme.colors.secondary, MaterialTheme.colors.secondary)
                )
            )
            .fillMaxWidth()
            .height(56.dp)
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}


@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar() {
        Text(text = "标题")
    }
}