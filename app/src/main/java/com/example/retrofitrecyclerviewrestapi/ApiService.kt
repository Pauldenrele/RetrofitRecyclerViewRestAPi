package com.example.retrofitrecyclerviewrestapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api/user/categories")
    fun fetchCategories(): Call<List<User>>

}