package com.example.dogcatapp.repository.service

import com.example.dogcatapp.repository.model.CatFactEntity
import retrofit2.Call
import retrofit2.http.GET

interface CatFactService {
    @GET("facts")
    fun getFact(): Call<CatFactEntity>
}