package com.franciscojavier.escorer.dto.League


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class LeaguesResultItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("modified_at")
    val modifiedAt: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("series")
    val series: List<Sery>,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("videogame")
    val videogame: Videogame
) : Parcelable