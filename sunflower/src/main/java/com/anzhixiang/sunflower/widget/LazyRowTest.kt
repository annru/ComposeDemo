package com.anzhixiang.sunflower.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun LazyRowTest() {


    val data = arrayListOf<Int>()
    for (index in 0..100) {
        data.add(index)
    }

    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(data) { dataItem ->
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "$dataItem",
                textAlign = TextAlign.Center
            )
        }
    }

}


@Composable
@Preview(backgroundColor = 0x661155, showBackground = true, heightDp = 400)
fun LazyRowTestPreview() {
    LazyRowTest()
}