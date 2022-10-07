package com.mehmetdulger.travelguideapp.ui.search

import retrofit2.Call
import retrofit2.http.GET

interface TravelGuideService {
    @GET ("AllTravelList")
    fun getDataFromApi(): Call<List<TravelGuideModel>>
}