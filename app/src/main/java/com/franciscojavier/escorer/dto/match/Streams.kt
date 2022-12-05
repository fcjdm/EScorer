package com.franciscojavier.escorer.dto.match


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Streams(
    @Json(name = "embed_url")
    val embedUrl: String,
    @Json(name = "language")
    val language: String,
    @Json(name = "main")
    val main: Boolean,
    @Json(name = "official")
    val official: Boolean,
    @Json(name = "raw_url")
    val rawUrl: String
) : Parcelable