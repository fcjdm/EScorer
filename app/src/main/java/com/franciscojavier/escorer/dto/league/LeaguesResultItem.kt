package com.franciscojavier.escorer.dto.league


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.franciscojavier.escorer.dto.game.GamesResultItem

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
    @SerializedName("slug")
    val slug: String,
    @SerializedName("videogame")
    val videogame: GamesResultItem
) : Parcelable