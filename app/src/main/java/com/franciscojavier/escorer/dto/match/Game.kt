package com.franciscojavier.escorer.dto.match


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class Game(
    @Json(name = "begin_at")
    val beginAt: String,
    @Json(name = "complete")
    val complete: Boolean,
    @Json(name = "detailed_stats")
    val detailedStats: Boolean,
    @Json(name = "end_at")
    val endAt: String,
    @Json(name = "finished")
    val finished: Boolean,
    @Json(name = "forfeit")
    val forfeit: Boolean,
    @Json(name = "id")
    val id: Int,
    @Json(name = "length")
    val length: Int,
    @Json(name = "match_id")
    val matchId: Int,
    @Json(name = "position")
    val position: Int,
    @Json(name = "status")
    val status: String,
    @Json(name = "winner")
    val winner: Winner,
    @Json(name = "winner_type")
    val winnerType: String
) : Parcelable