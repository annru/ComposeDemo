package com.test.composedemo.model.entity

class Config {

    companion object {
        val instance by lazy(LazyThreadSafetyMode.NONE) {
            Config()
        }
    }

    fun t(): Unit {

    }
}