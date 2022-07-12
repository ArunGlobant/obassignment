package com.obassignment.presentation.utils

import android.content.Context
import android.graphics.Bitmap
import android.icu.number.NumberRangeFormatter.with
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.obassignment.R


@BindingAdapter("urlToImage")
fun urlToImage(view: ImageView, imageUrl: String){

    val option = RequestOptions.placeholderOf(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)

    if(!imageUrl.startsWith("https:"))
    {
        Glide.with(view)
            .setDefaultRequestOptions(option)
            .load(imageUrl.replace("http:", "https:") ?: "")
            .into(view)

    }else{
        Glide.with(view)
            .setDefaultRequestOptions(option)
            .load(imageUrl ?: "")
            .into(view)
    }
}

