package com.franciscojavier.escorer.dto.match


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Game(
    @SerializedName("begin_at")
    val beginAt: String,
    @SerializedName("complete")
    val complete: Boolean,
    @SerializedName("detailed_stats")
    val detailedStats: Boolean,
    @SerializedName("end_at")
    val endAt: String,
    @SerializedName("finished")
    val finished: Boolean,
    @SerializedName("forfeit")
    val forfeit: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("length")
    val length: Int,
    @SerializedName("match_id")
    val matchId: Int,
    @SerializedName("position")
    val position: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("winner_type")
    val winnerType: String
) : Parcelable