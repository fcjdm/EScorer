package com.franciscojavier.escorer.dto.league


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.franciscojavier.escorer.dto.game.GamesResult
import kotlinx.parcelize.RawValue

@JsonClass(generateAdapter = true)
@Parcelize
data class LeaguesResult(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "modified_at")
    val modifiedAt: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "slug")
    val slug: String,
    @Json(name = "url")
    val url: @RawValue Any?,
    @Json(name = "videogame")
    val videogame: GamesResult?
) : Parcelable