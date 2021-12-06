package com.example.android.marsphotos.network

import com.squareup.moshi.Json

data class MarsPhoto (
    val id: String,

    // use this annotation if you want to use a different variable name
    @Json(name = "img_src")
    val imgSrcUrl: String
        )