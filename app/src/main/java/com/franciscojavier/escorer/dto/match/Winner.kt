package com.franciscojavier.escorer.dto.match


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Winner(
    @Json(name = "id")
    val id: Int,
    @Json(name = "type")
    val type: String
) : Parcelable