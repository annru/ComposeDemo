package com.anzhixiang.sunflower.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anzhixiang.sunflower.bean.Chat


@Composable
fun LazyColumnTest() {


    val data = mutableListOf("a", "b", "c", "d", "e")

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(data) { dataItem ->
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = dataItem,
                textAlign = TextAlign.Center
            )
        }
    }

}

@Composable
fun LazyColumnTestWithIndex() {
    val data = mutableListOf("a", "b", "c", "d", "e")
    LazyColumn(modifier = Modifier.fillMaxWidth()) {

        itemsIndexed(data) { index, dataItem ->
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "这是第${index + 1}条数据$dataItem",
                textAlign = TextAlign.Center
            )
        }
    }
}

//仿微信聊天界面
@Composable
fun LazyColumnTestChat() {
    val chatList = arrayListOf<Chat>()
    chatList.apply {
        add(Chat("你好啊，我是XXX介绍的", true))
        add(Chat("你好，很高兴认识你"))
        add(Chat("你是在上海吗", true))
        add(Chat("对啊，在上海，你呢"))
    }
    LazyColumn(modifier = Modifier.fillMaxWidth()) {

        items(chatList) { chat ->
            if (chat.isLeft) {


                CommonColumn(color = Color.White, alignment = Alignment.Start, msg = chat.msg)
            } else {
//                Column(modifier = Modifier.fillMaxWidth()) {
//                    Spacer(modifier = Modifier.padding(5.dp))
//                    Text(
//                        modifier = Modifier
//                            .background(Color.Blue)
//                            .padding(8.dp)
//                            .align(Alignment.End),
//                        text = chat.msg,
//                        textAlign = TextAlign.End
//                    )
//                }

                CommonColumn(color = Color.Blue, alignment = Alignment.End, msg = chat.msg)
            }
        }
    }
}

@Composable
fun CommonColumn(color: Color, alignment: Alignment.Horizontal, msg: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            modifier = Modifier
                .background(color)
                .padding(8.dp)
                .align(alignment),
            text = msg
        )
    }
}


@Composable
@Preview(backgroundColor = 0x661155, showBackground = true, widthDp = 200, heightDp = 400)
fun LazyColumnTestPreview() {
//    LazyColumnTest()
    LazyColumnTestChat()
}