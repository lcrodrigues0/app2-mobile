package com.example.dogcatapp.repository.service

import com.example.dogcatapp.repository.model.DogFactEntity
import retrofit2.Call
import retrofit2.http.GET

interface DogFactService {

    @GET("api/facts")
    fun getFact(): Call<DogFactEntity>
}