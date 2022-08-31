package com.anzhixiang.sunflower.mutex

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.lang.Thread.sleep

class MutextDemo {


}


@OptIn(DelicateCoroutinesApi::class)
fun main() {

    var value = 0
    val mutex = Mutex()
    repeat(100) { itw ->
//        print("外层---$itw")
        GlobalScope.launch(Dispatchers.Default) {
            mutex.withLock {
                repeat(10000) {
//                    print("内层---$it")
                    value++
                }
            }
        }
    }
    sleep(100)
    println("")
    println("value=$value")

}