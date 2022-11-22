package com.franciscojavier.escorer.dto.match


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Result(
    @SerializedName("score")
    val score: Int,
    @SerializedName("team_id")
    val teamId: Int
) : Parcelable