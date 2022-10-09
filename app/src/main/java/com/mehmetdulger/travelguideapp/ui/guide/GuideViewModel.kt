package com.mehmetdulger.travelguideapp.ui.guide

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mehmetdulger.travelguideapp.TravelGuideApi
import com.mehmetdulger.travelguideapp.TravelGuideModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GuideViewModel : ViewModel() {

    val uiModelMightNeedThese: MutableLiveData<List<TravelGuideModel>> = MutableLiveData()
    val uiModelTopPickArticles: MutableLiveData<List<TravelGuideModel>> = MutableLiveData()
    val error: MutableLiveData<Unit> = MutableLiveData()

    init {
        fetchMightNeedTheseTravelGuide()
        fetchTopPickArticlesTravelGuide()
    }

    private fun fetchMightNeedTheseTravelGuide() {
        TravelGuideApi.retrofitService.getDataFromApi("mightneed")
            .enqueue(object : Callback<List<TravelGuideModel>> {
                override fun onResponse(
                    call: Call<List<TravelGuideModel>>,
                    response: Response<List<TravelGuideModel>>
                ) {
                    response.body()
                        ?.let { responseList -> uiModelMightNeedThese.value = responseList }
                    if (response.isSuccessful) {
                        uiModelMightNeedThese.value = response.body()
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

    private fun fetchTopPickArticlesTravelGuide() {
        TravelGuideApi.retrofitService.getDataFromApi("toppick")
            .enqueue(object : Callback<List<TravelGuideModel>> {
                override fun onResponse(
                    call: Call<List<TravelGuideModel>>,
                    response: Response<List<TravelGuideModel>>
                ) {
                    response.body()
                        ?.let { responseList -> uiModelTopPickArticles.value = responseList }
                    if (response.isSuccessful) {
                        uiModelTopPickArticles.value = response.body()
                    }else{
                        error.value = Unit
                    }
                }

                override fun onFailure(call: Call<List<TravelGuideModel>>, t: Throwable) {
                    Log.v("ERROR",t.message.toString())
                    error.value = Unit
                }
            })
    }

}

