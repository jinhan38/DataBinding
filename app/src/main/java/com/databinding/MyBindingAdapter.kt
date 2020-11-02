package com.databinding

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object MyBindingAdapter {


//    companion object {


    @BindingAdapter("imageUrl")
    fun loadImageUrl(view: ImageView, url: String) {

        Log.d(TAG, "loadImageUrl: $url")


        Glide.with(view.context)
            .load(url)
            .into(view)

//    }
    }
}