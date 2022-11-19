package com.franciscojavier.escorer.model.server

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PandaScoreClient {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.pandascore.co/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val service = retrofit.create(PandaScoreService::class.java)
}