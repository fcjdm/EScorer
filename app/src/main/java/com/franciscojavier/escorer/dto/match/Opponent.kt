package com.franciscojavier.escorer.dto.match


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Opponent(
    @SerializedName("opponent")
    val opponent: OpponentX,
    @SerializedName("type")
    val type: String
) : Parcelable