package com.franciscojavier.escorer.model.server

import com.franciscojavier.escorer.BuildConfig
import com.franciscojavier.escorer.NULL_TO_EMPTY_STRING_ADAPTER
import com.franciscojavier.escorer.NULL_TO_ZERO_ADAPTER
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object PandaScoreClient {

    private val moshi = Moshi.Builder()
        .add(NULL_TO_EMPTY_STRING_ADAPTER)
        .add(NULL_TO_ZERO_ADAPTER)
        .add(KotlinJsonAdapterFactory())
        .build()

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.pandascore.co/")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi)).build()

    val service = retrofit.create(PandaScoreService::class.java)
}