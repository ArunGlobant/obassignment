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
import com.obassignment.common.Constants.Companion.EMPTY_VALUE


@BindingAdapter("urlToImage")
fun urlToImage(view: ImageView, imageUrl: String){

    val option = RequestOptions.placeholderOf(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)

    if(!imageUrl.startsWith("https:"))
    {
        Glide.with(view)
            .setDefaultRequestOptions(option)
            .load(imageUrl.replace("http:", "https:") ?: EMPTY_VALUE)
            .into(view)

    }else{
        Glide.with(view)
            .setDefaultRequestOptions(option)
            .load(imageUrl ?: EMPTY_VALUE)
            .into(view)
    }
}

