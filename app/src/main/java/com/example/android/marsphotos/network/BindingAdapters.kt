package com.example.android.marsphotos.network

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        //convert the url string to a Uri object
        imgUrl.toUri()
        // to use the HTTPS schema
            .buildUpon().scheme("https").build()
        // load() {} from Coil library
        imgView.load(imgUrl)
    }
}