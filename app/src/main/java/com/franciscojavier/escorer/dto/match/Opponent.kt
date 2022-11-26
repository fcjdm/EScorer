package com.franciscojavier.escorer.dto.match


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Opponent(
    @Json(name = "opponent")
    val opponent: OpponentX,
    @Json(name = "type")
    val type: String
) : Parcelable