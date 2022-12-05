package com.franciscojavier.escorer.dto.match


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Live(
    @Json(name = "opens_at")
    val opensAt: String,
    @Json(name = "supported")
    val supported: Boolean,
    @Json(name = "url")
    val url: String
) : Parcelable