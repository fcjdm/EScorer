package com.franciscojavier.escorer.model.server

import com.franciscojavier.escorer.NULL_TO_EMPTY_STRING_ADAPTER
import com.franciscojavier.escorer.NULL_TO_ZERO_ADAPTER
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object PandaScoreClient {

    private val moshi = Moshi.Builder()
        .add(NULL_TO_EMPTY_STRING_ADAPTER)
        .add(NULL_TO_ZERO_ADAPTER)
        .add(KotlinJsonAdapterFactory())
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.pandascore.co/")
        .addConverterFactory(MoshiConverterFactory.create(moshi)).build()

    val service = retrofit.create(PandaScoreService::class.java)
}