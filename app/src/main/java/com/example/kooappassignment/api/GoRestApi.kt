package com.example.kooappassignment.api

import com.example.kooappassignment.api.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GoRestApi {

    companion object {
        const val BASE_URL = "https://gorest.co.in/public/v1/"
    }

    @GET("posts")
    suspend fun getPosts(
        @Query("page") page: Int
    ): ApiResponse
}