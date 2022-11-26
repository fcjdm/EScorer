package com.franciscojavier.escorer.dto.match


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.franciscojavier.escorer.dto.game.GamesResult
import com.franciscojavier.escorer.dto.league.LeaguesResult
import kotlinx.parcelize.RawValue

@JsonClass(generateAdapter = true)
@Parcelize
data class MatchResult(
    @Json(name = "begin_at")
    val beginAt: String? = null,
    @Json(name = "detailed_stats")
    val detailedStats: Boolean,
    @Json(name = "draw")
    val draw: Boolean,
    @Json(name = "end_at")
    val endAt: String?,
    @Json(name = "forfeit")
    val forfeit: Boolean,
    @Json(name = "game_advantage")
    val gameAdvantage: @RawValue Any?,
    @Json(name = "games")
    val games: List<Game>,
    @Json(name = "id")
    val id: Int,
    @Json(name = "league")
    val league: LeaguesResult,
    @Json(name = "league_id")
    val leagueId: Int,
    @Json(name = "live")
    val live: Live,
    @Json(name = "match_type")
    val matchType: String,
    @Json(name = "modified_at")
    val modifiedAt: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "number_of_games")
    val numberOfGames: Int,
    @Json(name = "opponents")
    val opponents: List<Opponent>,
    @Json(name = "original_scheduled_at")
    val originalScheduledAt: String,
    @Json(name = "rescheduled")
    val rescheduled: Boolean,
    @Json(name = "results")
    val results: List<Result>,
    @Json(name = "scheduled_at")
    val scheduledAt: String,
    @Json(name = "serie_id")
    val serieId: Int,
    @Json(name = "slug")
    val slug: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "streams_list")
    val streamsList: List<Streams>,
    @Json(name = "tournament_id")
    val tournamentId: Int,
    @Json(name = "videogame")
    val videogame: GamesResult,
    @Json(name = "winner")
    val winner: WinnerX?,
    @Json(name = "winner_id")
    val winnerId: Int,
    @Json(name = "winner_type")
    val winnerType: String
) : Parcelable