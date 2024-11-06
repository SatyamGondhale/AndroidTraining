package com.sanjivani.optionsmenudemo.api

import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun getPostsList()
}