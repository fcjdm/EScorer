package com.franciscojavier.escorer.model.server

import com.franciscojavier.escorer.dto.game.GamesResult
import com.franciscojavier.escorer.dto.League.LeaguesResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PandaScoreService {

    @GET("videogames")
    suspend fun getGames(@Query("token")apiKey: String) : GamesResult

    @GET("videogames/{slug}/leagues")
    suspend fun getLeagues(@Path("slug") slug: String, @Query("token")apiKey: String) : LeaguesResult
}