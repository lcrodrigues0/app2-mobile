package com.example.dogcatapp.repository.client

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class FactClientRetrofit {
    companion object {
        private lateinit var INSTANCE: Retrofit
        private const val CAT_BASE_URL = "https://catfact.ninja/"
        private const val DOG_BASE_URL = "https://dog-api.kinduff.com/"

        private fun getFactClientInstance(baseUrl: String): Retrofit {
            if(!::INSTANCE.isInitialized) {
                val http = OkHttpClient.Builder()
                INSTANCE = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return INSTANCE
        }

        fun <S> createCatFactService(className: Class<S>): S {
            return getFactClientInstance(CAT_BASE_URL).create(className)
        }

        fun <S> createDogFactService(className: Class<S>): S {
            return getFactClientInstance(DOG_BASE_URL).create(className)
        }
    }
}