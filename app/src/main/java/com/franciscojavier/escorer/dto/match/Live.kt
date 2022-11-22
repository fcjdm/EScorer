package com.franciscojavier.escorer.dto.match


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Live(
    @SerializedName("opens_at")
    val opensAt: String,
    @SerializedName("supported")
    val supported: Boolean,
    @SerializedName("url")
    val url: String
) : Parcelable