package com.mehmetdulger.travelguideapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TravelGuideApi {
    companion object {
        private const val BASE_URL = "https://633800d85327df4c43db5614.mockapi.io/"

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        val retrofitService: TravelGuideService by lazy {
            retrofit.create(TravelGuideService::class.java)
        }
    }

}