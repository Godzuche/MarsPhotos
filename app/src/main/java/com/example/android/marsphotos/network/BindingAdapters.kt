package com.example.android.marsphotos.network

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load


// data binding executes this binding adapter when a view item(e.g imageView) has app:imageUrl attribute
@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    // Load the image in the background using Coil
    imgUrl?.let {
        //convert the url string to a Uri object
        imgUrl.toUri()
        // to use the HTTPS schema
            .buildUpon().scheme("https").build()
        // load() {} from Coil library
        imgView.load(imgUrl)
    }
}