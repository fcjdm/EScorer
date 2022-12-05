package com.franciscojavier.escorer

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat

fun ImageView.loadUrl(url: String){
    Glide.with(this)
        .load(url)
        .into(this)
}

fun ViewGroup.inflate(layout: Int, attachToRoot: Boolean = true) =
    LayoutInflater.from(context).inflate(layout, this, attachToRoot)

fun DateConverter(date: String): String {
    val strCurrentDate = date
    var format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    val newDate = format.parse(strCurrentDate)
    format = SimpleDateFormat("dd MMM, yyyy hh:mm a z");
    return format.format(newDate)
}
