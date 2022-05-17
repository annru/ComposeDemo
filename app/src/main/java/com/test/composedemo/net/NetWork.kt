package com.test.composedemo.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetWork {

    private val url =
        "https://mock.apipost.cn/app/mock/project/ced69cf2-9206-4a42-895e-dd7442a888df/"


    private val retrofit =
        Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()

    fun <T> createService(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}