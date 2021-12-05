package com.example.android.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

// The base url
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

// Retrofit  builder to create a Retrofit object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()