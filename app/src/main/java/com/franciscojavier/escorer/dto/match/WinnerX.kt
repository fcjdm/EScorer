package com.franciscojavier.escorer.dto.match


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import kotlinx.parcelize.RawValue

@JsonClass(generateAdapter = true)
@Parcelize
data class WinnerX(
    @Json(name = "acronym")
    val acronym: String?,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "location")
    val location: String?,
    @Json(name = "modified_at")
    val modifiedAt: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "slug")
    val slug: String
) : Parcelable