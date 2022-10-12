package com.mehmetdulger.travelguideapp.data.remote

import com.mehmetdulger.travelguideapp.TravelGuideCategoriesModel
import com.mehmetdulger.travelguideapp.TravelGuideModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TravelGuideService {

    @GET ("AllTravelList")
    fun getDataFromApi(@Query("category") category: String): Call<List<TravelGuideModel>>

    @GET ("AllTravelList")
    fun getDataFromApiBookmark(@Query("isBookmark") isBookmark: String): Call<List<TravelGuideModel>>


    @GET ("GuideCategories")
    fun getDataFromApiCategories(): Call<List<TravelGuideCategoriesModel>>

}