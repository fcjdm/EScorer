package com.franciscojavier.escorer.dto.match


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.franciscojavier.escorer.dto.league.LeaguesResultItem

@Parcelize
data class MatchResultItem(
    @SerializedName("begin_at")
    val beginAt: String,
    @SerializedName("detailed_stats")
    val detailedStats: Boolean,
    @SerializedName("draw")
    val draw: Boolean,
    @SerializedName("end_at")
    val endAt: String,
    @SerializedName("forfeit")
    val forfeit: Boolean,
    @SerializedName("game_advantage")
    val gameAdvantage: String,
    @SerializedName("games")
    val games: List<Game>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("league")
    val league: LeaguesResultItem,
    @SerializedName("league_id")
    val leagueId: Int,
    @SerializedName("live")
    val live: Live,
    @SerializedName("match_type")
    val matchType: String,
    @SerializedName("modified_at")
    val modifiedAt: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("number_of_games")
    val numberOfGames: Int,
    @SerializedName("opponents")
    val opponents: List<Opponent>,
    @SerializedName("original_scheduled_at")
    val originalScheduledAt: String,
    @SerializedName("rescheduled")
    val rescheduled: Boolean,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("scheduled_at")
    val scheduledAt: String,
    @SerializedName("serie_id")
    val serieId: Int,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("tournament_id")
    val tournamentId: Int,
    @SerializedName("winner_id")
    val winnerId: Int,
    @SerializedName("winner_type")
    val winnerType: String
) : Parcelable