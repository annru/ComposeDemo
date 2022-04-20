package com.test.composedemo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.test.composedemo.R
import com.test.composedemo.model.entity.MenuItem
import com.test.composedemo.ui.components.TopAppBar


@Composable
fun MineScreen() {
    var menus = listOf(
        MenuItem(Icons.Default.Notifications, "学习积分"),
        MenuItem(Icons.Default.Face, "浏览记录"),
        MenuItem(Icons.Default.Refresh, "学习档案")
    )

    val constraintSet = ConstraintSet {
        val icon = createRefFor("icon")
        val name = createRefFor("name")
        val arrow = createRefFor("arrow")
        val divider = createRefFor("divider")

        constrain(icon) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }
        constrain(name) {
            start.linkTo(icon.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }
        constrain(arrow) {
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }
        constrain(divider) {
            bottom.linkTo(parent.bottom)
            start.linkTo(name.start)
            end.linkTo(parent.end)
        }
    }

    Column() {
        TopAppBar {
            Text(text = "我的")
        }

        LazyColumn(modifier = Modifier.padding(8.dp)) {
            item {
                Row(
                    modifier = Modifier.padding(vertical = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.mipmap.ic_head),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(62.dp)
                            .clip(CircleShape)
                    )
                    Column(
                        verticalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .padding(8.dp)
                            .height(62.dp)
                    ) {
                        Text(text = "未登录", color = Color(0xFF333333), fontSize = 18.sp)
                        Text(text = "已坚持学习23天", color = Color(0xFF999999), fontSize = 12.sp)
                    }
                }
            }



            items(menus) { menu ->

                ConstraintLayout(
                    constraintSet, modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Icon(
                        imageVector = menu.icon,
                        contentDescription = null,
                        modifier = Modifier.layoutId("icon")
                    )
                    Text(
                        text = menu.name,
                        color = Color(0xFF333333),
                        fontSize = 16.sp,
                        modifier = Modifier
                            .layoutId("name")
                            .padding(8.dp)

                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.layoutId("arrow")
                    )
                    Divider(
                        modifier = Modifier
                            .layoutId("divider")
                            .padding(start = 5.dp, end = 5.dp)

                    )
                }

            }
        }
    }
}


@Composable
fun MineScreenPreview() {
    MineScreen()
}