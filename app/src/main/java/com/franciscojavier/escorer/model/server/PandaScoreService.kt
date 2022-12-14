package com.franciscojavier.escorer.model.server

import com.franciscojavier.escorer.dto.game.GamesResult
import com.franciscojavier.escorer.dto.league.LeaguesResult
import com.franciscojavier.escorer.dto.match.GameMatchResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PandaScoreService {

    @GET("videogames")
    suspend fun getGames(@Query("token")apiKey: String) : List<GamesResult>

    @GET("videogames/{game-slug}/leagues")
    suspend fun getLeagues(@Path("game-slug") gameSlug: String, @Query("token")apiKey: String) : List<LeaguesResult>

    @GET("leagues/{league-slug}/matches")
    suspend fun getMatches(@Path("league-slug") leagueSlug: String, @Query("token")apiKey: String) : List<GameMatchResult>
}