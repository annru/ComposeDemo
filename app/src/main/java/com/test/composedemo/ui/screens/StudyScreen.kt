package com.test.composedemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.google.accompanist.pager.HorizontalPager
import com.test.composedemo.ui.components.*
import com.test.composedemo.ui.components.TopAppBar
import com.test.composedemo.ui.viewmodel.ArticleViewModel
import com.test.composedemo.ui.viewmodel.MainViewModel
import com.test.composedemo.ui.viewmodel.VideoViewModel


@OptIn(ExperimentalMaterialApi::class, com.google.accompanist.pager.ExperimentalPagerApi::class)
@Composable
fun StudyScreen(
    vm: MainViewModel = viewModel(),
    articleViewModel: ArticleViewModel = viewModel(),
    videoViewModel: VideoViewModel = viewModel()
) {

    Column() {
        //标题栏
        TopAppBar {


            //搜索按钮
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .weight(1f),
                color = Color(0x33FFFFFF)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(15.dp)
                    )
                    Text(
                        text = "搜索感兴趣的资讯或课程",
                        fontSize = 14.sp,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            //学习进度
            Text(text = "学习\n进度", color = Color.White, fontSize = 12.sp)

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = "26%", color = Color.White, fontSize = 14.sp)

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null,
                tint = Color.White
            )


        }
        //分类标签
        TabRow(
            selectedTabIndex = vm.categoryIndex,
            backgroundColor = Color(0x22149EE7),
            contentColor = Color(0x66149EE7)
        ) {
            vm.categories.forEachIndexed { index, category ->
                Tab(
                    selected = vm.categoryIndex == index,
                    onClick = {
                        vm.updateCategoryIndex(index)
                    },
                    selectedContentColor = Color(0xFF149EE7),
                    unselectedContentColor = Color(0xFF666666)
                ) {
                    Text(text = category.title, modifier = Modifier.padding(8.dp))
                }
            }
        }

        //类型
        TabRow(
            selectedTabIndex = vm.typeIndex,
            backgroundColor = Color.Transparent, contentColor = Color(0xFF149EE7),
            indicator = {},
            divider = {}
        ) {
            vm.types.forEachIndexed { index, s ->
                LeadingIconTab(
                    selected = vm.typeIndex == index, onClick = {
                        vm.updateTypeIndex(index)
                    },
                    selectedContentColor = Color(0xFF149EE7),
                    unselectedContentColor = Color(0xFF666666),
                    text = {
                        Text(text = s, modifier = Modifier.padding(8.dp), fontSize = 16.sp)
                    },
                    icon = {
                        Icon(imageVector = Icons.Default.Place, contentDescription = null)
                    }
                )
            }
        }

        LazyColumn() {
            item {
                //轮播图
                SwipeContent(vm)
            }

            item {
                //通知
                NotificationContent(vm)
            }

            if (vm.showArticleList) {
                items(articleViewModel.list) { article ->
                    ArticleItem(article)
                }
            } else {
                items(videoViewModel.list) { videoEntity ->
                    VideoItem(videoEntity = videoEntity)
                }
            }
        }
    }
}


@Composable
fun StudyScreenPreview() {
    StudyScreen()
}