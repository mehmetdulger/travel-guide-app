package com.mehmetdulger.travelguideapp.ui.search

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class TravelGuideApi {
    companion object {
        private const val BASE_URL = "https://633800d85327df4c43db5614.mockapi.io/"

//gereksiz
        fun getTravelGuideApi():Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        val retrofitService: TravelGuideService by lazy {
            retrofit.create(TravelGuideService::class.java)
        }
    }





}