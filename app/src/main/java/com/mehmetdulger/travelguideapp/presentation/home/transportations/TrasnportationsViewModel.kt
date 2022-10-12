package com.mehmetdulger.travelguideapp.presentation.home.transportations

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mehmetdulger.travelguideapp.TravelGuideApi
import com.mehmetdulger.travelguideapp.TravelGuideModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrasnportationsViewModel : ViewModel() {
    val uiModelTransportations: MutableLiveData<List<TravelGuideModel>> = MutableLiveData()
    val error: MutableLiveData<Unit> = MutableLiveData()

    init {
        fetchTransportationsTravelsGuide()
    }

    private fun fetchTransportationsTravelsGuide() {
        TravelGuideApi.retrofitService.getDataFromApi("transportation")
            .enqueue(object : Callback<List<TravelGuideModel>> {
                override fun onResponse(
                    call: Call<List<TravelGuideModel>>,
                    response: Response<List<TravelGuideModel>>
                ) {
                    response.body()?.let { responseList -> uiModelTransportations.value = responseList }
                    if (response.isSuccessful) {
                        uiModelTransportations.value = response.body()
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