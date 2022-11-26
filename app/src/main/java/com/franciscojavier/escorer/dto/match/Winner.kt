package com.franciscojavier.escorer.dto.match


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Winner(
    @SerializedName("id")
    val id: Int,
    @SerializedName("type")
    val type: String
) : Parcelable