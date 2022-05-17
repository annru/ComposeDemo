package com.test.composedemo.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.test.composedemo.net.Api
import com.test.composedemo.net.NetWork
import kotlinx.coroutines.*
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.coroutines.coroutineContext

class HomeViewModel : ViewModel() {


    val api = NetWork().createService(Api::class.java)


    suspend fun login() {
        api.login()
    }

}


 suspend fun test() {
    var count = 0
    val mutex = Mutex()
    coroutineScope {
        repeat(1000) {
            mutex.withLock {
                count++
            }
            println("中间值：$count")
        }
    }
    delay(1000)
    println("计算结果：$count")
}

@OptIn(DelicateCoroutinesApi::class)
fun main(){
    GlobalScope.launch {
        test()
    }
}