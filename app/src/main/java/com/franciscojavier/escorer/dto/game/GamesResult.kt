package com.franciscojavier.escorer.dto.game


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import kotlinx.parcelize.RawValue

@JsonClass(generateAdapter = true)
@Parcelize
data class GamesResult(
    @Json(name = "current_version")
    val currentVersion: @RawValue Any?,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "slug")
    val slug: String
) : Parcelable