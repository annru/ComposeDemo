package com.test.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import com.test.composedemo.ui.screens.MainFrame
import com.test.composedemo.ui.theme.ComposeDemoTheme

class HomeActivity : ComponentActivity() {

    private val titles = arrayListOf("聊天", "通讯录", "发现", "我")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
//                Scaffold(bottomBar = {
//                    TabBar()
//                }, topBar = {
//                    MyTopBar()
//                }) {
//                    val count = remember {
//                        mutableStateOf(0)
//                    }
//                    Text(
//                        text = count.value.toString(),
//                        Modifier
//                            .fillMaxSize()
//                            .background(color = Color.Magenta)
//                            .clickable {
//                                count.value += 1
//                            }, textAlign = TextAlign.Center
//                    )
//                }
//                HelloContent()

                MainFrame()
            }
        }
    }


    @Composable
    fun HelloContent() {
        val inputText = remember { mutableStateOf("") }

        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = "hello",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )

            OutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it },
                label = { Text(text = "Name") })

        }
    }


    @Composable
    fun MyTopBar() {
        Row(
            Modifier.padding(28.dp, 28.dp, 28.dp, 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(R.mipmap.ic_header),
                "头像",
                Modifier
                    .clip(CircleShape)
                    .size(64.dp)
            )
            Column(
                Modifier
                    .padding(start = 14.dp)
                    .weight(1f)
            ) {
                Text("欢迎回来", fontSize = 14.sp, color = Color.Gray)
                Text("安哥", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
            Surface(Modifier.clip(CircleShape), color = Color.LightGray) {
                Image(
                    painterResource(R.mipmap.ic_notification),
                    "通知",
                    Modifier
                        .padding(10.dp)
                        .size(32.dp)
                )

            }
        }
    }


    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeDemoTheme {
            TabBar()
        }
    }

    @Composable
    fun TabItem(
        @DrawableRes iconId: Int,
        color: Color,
        name: String,
        modifier: Modifier = Modifier
    ) {
        Button(
            onClick = { /*TODO*/ },
            shape = RectangleShape,
            colors = ButtonDefaults.outlinedButtonColors()
        ) {
            Column(
                modifier = modifier.padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(painterResource(id = iconId), name, Modifier.size(36.dp), tint = color)
                Text(name, fontSize = 16.sp, color = color, modifier = Modifier.padding(top = 8.dp))
            }
        }

    }

    @Composable
    fun TabBar() {
        Row(
            modifier = Modifier.background(Color.White),
            verticalAlignment = Alignment.Bottom
        ) {
            for ((index, title) in titles.withIndex()) {
                TabItem(
                    iconId = getIconResId(index),
                    color = Color.Green,
                    name = title,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }


    private fun getIconResId(index: Int): Int {
        return when (index) {
            0 -> R.mipmap.chat
            1 -> R.mipmap.contacts
            2 -> R.mipmap.discover
            3 -> R.mipmap.me
            else -> 0
        }
    }

}