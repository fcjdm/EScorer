package com.franciscojavier.escorer.model.server

import com.franciscojavier.escorer.dto.GamesResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PandaScoreService {

    @GET("videogames")
    suspend fun getGames(@Query("token")apiKey: String) : GamesResult
}