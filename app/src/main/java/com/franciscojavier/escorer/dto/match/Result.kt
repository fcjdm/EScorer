package com.franciscojavier.escorer.dto.match


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Result(
    @Json(name = "score")
    val score: Int?,
    @Json(name = "team_id")
    val teamId: Int?
) : Parcelable