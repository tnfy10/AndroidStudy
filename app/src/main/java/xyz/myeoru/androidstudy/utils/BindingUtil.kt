package xyz.myeoru.androidstudy.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide

@BindingAdapter("app:url")
fun getNetworkImage(view: ImageView, url: String) {
    val circularProgressDrawable = CircularProgressDrawable(view.context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()

    Glide.with(view.context)
        .load(url)
        .placeholder(circularProgressDrawable)
        .error(circularProgressDrawable)
        .into(view)
}