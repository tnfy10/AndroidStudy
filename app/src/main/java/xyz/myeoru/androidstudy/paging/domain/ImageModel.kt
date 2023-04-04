package xyz.myeoru.androidstudy.paging.domain

import com.google.gson.annotations.SerializedName

data class ImageModel(
    val id: Int,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    @SerializedName("download_url")
    val downloadUrl: String
)
