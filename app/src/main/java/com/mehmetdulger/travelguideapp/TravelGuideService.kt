package com.mehmetdulger.travelguideapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TravelGuideService {
   /* @GET ("AllTravelList")
    fun getDataFromApi(): Call<List<TravelGuideModel>>
*/
    @GET ("AllTravelList")
    fun getDataFromApi(@Query("category") category: String): Call<List<TravelGuideModel>>


}