package com.anzhixiang.sunflower

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.databinding.DataBindingUtil
import com.anzhixiang.sunflower.databinding.ActivityMainBinding
import com.anzhixiang.sunflower.effect.sample.RememberUpdateStateSample
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)




        binding.composeView.setContent {
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(text = "可是红颜容易老去", fontSize = 18.sp)
//            }

//            HelloContent()
            RememberUpdateStateSample()
        }


    }

    /**


    @Composable
    fun ScaffoldSample() {
    val scaffoldstate = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
    scaffoldState = scaffoldstate,
    drawerContent = {
    Text(text = "屏幕内容区域")
    },
    topBar = {
    TopAppBar(
    title = { Text(text = "脚手架示例") },
    navigationIcon = {
    IconButton(onClick = {
    scope.launch {
    scaffoldstate.drawerState.open()
    }
    }) {
    Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
    }
    }) {
    }
    }
    ) {

    }
    }

     *
     */


    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    fun HelloContent() {
        val inputText = remember { mutableStateOf("") }
        val scope = rememberCoroutineScope()
        Column(modifier = Modifier.padding(16.dp)) {
            scope.launch(Dispatchers.Main) {
                for (i in 0..10000) {
                    delay(1000)
                    Log.i("HelloContent", "i=$i")
                }
            }

            DisposableEffect(key1 = inputText.value) {
                Log.i("HelloContent", "on disposable ")
                onDispose {
                    Log.i("HelloContent", "onDisposable ")
                }
            }

            Text(
                text = "Hello",
                modifier = Modifier.padding(bottom = 16.dp),
                style = MaterialTheme.typography.h5
            )

            OutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it },
                label = { Text(text = "Name") })

        }
    }
}