package com.franciscojavier.escorer.dto


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Sery(
    @SerializedName("begin_at")
    val beginAt: String,
    @SerializedName("end_at")
    val endAt: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("league_id")
    val leagueId: Int,
    @SerializedName("modified_at")
    val modifiedAt: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("season")
    val season: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("winner_id")
    val winnerId: Int,
    @SerializedName("winner_type")
    val winnerType: String,
    @SerializedName("year")
    val year: Int
) : Parcelable