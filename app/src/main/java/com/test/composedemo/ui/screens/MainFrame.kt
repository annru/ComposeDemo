package com.test.composedemo.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.test.composedemo.model.entity.NavigationItem


@Composable
fun MainFrame() {
    val navigationItems = listOf(
        NavigationItem(title = "学习", icon = Icons.Filled.Home),
        NavigationItem(title = "任务", icon = Icons.Filled.DateRange),
        NavigationItem(title = "我的", icon = Icons.Filled.Person)
    )

    var currIndex by remember {
        mutableStateOf(0)
    }


    Scaffold(bottomBar = {
        BottomNavigation(backgroundColor = MaterialTheme.colors.surface) {
            navigationItems.forEachIndexed { index, navigationItem ->
                BottomNavigationItem(
                    selected = currIndex == index,
                    onClick = { currIndex = index },
                    icon = { Icon(imageVector = navigationItem.icon, contentDescription = null) },
                    label = { Text(text = navigationItem.title) },
                    selectedContentColor = Color(0xFF149EE7),
                    unselectedContentColor = Color(0xFF999999)
                )
            }
        }
    }) {
        Box(modifier = Modifier.padding(it)) {
            when (currIndex) {
                0 -> StudyScreen()
                1 -> TaskScreen()
                2 -> MineScreen()
            }
        }
    }
}

@Composable
fun MainFramePreview() {
    MainFrame()
}