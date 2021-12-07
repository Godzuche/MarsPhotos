package com.example.android.marsphotos.network

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.marsphotos.R
import com.example.android.marsphotos.overview.PhotoGridAdapter


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
        imgView.load(imgUrl) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MarsPhoto>?) {
    // Cast recyclerView.adapter to PhotoGridAdapter
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}