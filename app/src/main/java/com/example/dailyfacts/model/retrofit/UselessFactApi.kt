package com.example.dailyfacts.model.retrofit

import com.example.dailyfacts.model.UselessFact
import retrofit2.Response
import retrofit2.http.GET

interface UselessFactApi {
    @GET("/api/v2/facts/random")
    suspend fun getRandomUselessFact() : UselessFact

    @GET("/api/v2/facts/today")
    suspend fun getTodayUselessFact() : UselessFact
}