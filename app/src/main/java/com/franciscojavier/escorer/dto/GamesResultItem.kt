package com.franciscojavier.escorer.dto


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class GamesResultItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("leagues")
    val leagues: List<League>,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
) : Parcelable