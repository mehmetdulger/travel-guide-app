package com.mehmetdulger.travelguideapp.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mehmetdulger.travelguideapp.TravelGuideApi
import com.mehmetdulger.travelguideapp.TravelGuideModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {
    val uiModelTopDestination: MutableLiveData<List<TravelGuideModel>> = MutableLiveData()
    val uiModelNearbyAttraction: MutableLiveData<List<TravelGuideModel>> = MutableLiveData()
    val error: MutableLiveData<Unit> = MutableLiveData()

    init {
        fetchTopTravelsGuide()
        fetchNearbyTravelsGuide()
    }

    private fun fetchTopTravelsGuide() {
        TravelGuideApi.retrofitService.getDataFromApi("topdestination")
            .enqueue(object : Callback<List<TravelGuideModel>> {
                override fun onResponse(
                    call: Call<List<TravelGuideModel>>,
                    response: Response<List<TravelGuideModel>>
                ) {
                    response.body()?.let { responseList -> uiModelTopDestination.value = responseList }
                    if (response.isSuccessful) {
                        uiModelTopDestination.value = response.body()
                    } else {
                        error.value = Unit
                    }
                }

                override fun onFailure(call: Call<List<TravelGuideModel>>, t: Throwable) {
                    Log.v("ERROR", t.message.toString())
                    error.value = Unit
                }
            })
    }

    private fun fetchNearbyTravelsGuide() {
        TravelGuideApi.retrofitService.getDataFromApi("nearby")
            .enqueue(object : Callback<List<TravelGuideModel>> {
                override fun onResponse(
                    call: Call<List<TravelGuideModel>>,
                    response: Response<List<TravelGuideModel>>
                ) {
                    response.body()?.let { responseList -> uiModelNearbyAttraction.value = responseList }
                    if (response.isSuccessful) {
                        uiModelNearbyAttraction.value = response.body()
                    } else {
                        error.value = Unit
                    }
                }

                override fun onFailure(call: Call<List<TravelGuideModel>>, t: Throwable) {
                    Log.v("ERROR", t.message.toString())
                    error.value = Unit
                }
            })
    }
}