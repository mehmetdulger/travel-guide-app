package com.mehmetdulger.travelguideapp.presentation.trip.bookmark

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mehmetdulger.travelguideapp.TravelGuideApi
import com.mehmetdulger.travelguideapp.TravelGuideModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookmarkViewModel : ViewModel() {
    val uiModelBookmark: MutableLiveData<List<TravelGuideModel>> = MutableLiveData()
    val error: MutableLiveData<Unit> = MutableLiveData()

    init {
        fetchBookmarkTravelsGuide()
    }

    private fun fetchBookmarkTravelsGuide() {
        TravelGuideApi.retrofitService.getDataFromApiBookmark("false")
            .enqueue(object : Callback<List<TravelGuideModel>> {
                override fun onResponse(
                    call: Call<List<TravelGuideModel>>,
                    response: Response<List<TravelGuideModel>>
                ) {
                    response.body()?.let { responseList -> uiModelBookmark.value = responseList }
                    if (response.isSuccessful) {
                        uiModelBookmark.value = response.body()
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