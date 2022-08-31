package com.anzhixiang.sunflower.widget

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anzhixiang.sunflower.R


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyVerticalGridTest() {


    val photos = arrayListOf<Int>()
    for (index in 0..20) {
        photos.add(R.mipmap.ic_bg)
    }

    LazyVerticalGrid(cells = GridCells.Fixed(3)) {
        items(photos) { photo ->
            Image(
                painter = painterResource(id = photo),
                contentDescription = null,
                modifier = Modifier.padding(2.dp)
            )
        }
    }

}


@Composable
@Preview(backgroundColor = 0x661155, showBackground = true, heightDp = 400)
fun LazyVerticalGridTestPreview() {
    LazyVerticalGridTest()
}