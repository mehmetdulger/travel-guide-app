package com.mehmetdulger.travelguideapp.ui.guide

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mehmetdulger.travelguideapp.TravelGuideApi
import com.mehmetdulger.travelguideapp.TravelGuideCategoriesModel
import com.mehmetdulger.travelguideapp.TravelGuideModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GuideViewModel : ViewModel() {

    val uiModelMightNeedThese: MutableLiveData<List<TravelGuideModel>> = MutableLiveData()
    val uiModelTopPickArticles: MutableLiveData<List<TravelGuideModel>> = MutableLiveData()
    val uiModelChip: MutableLiveData<List<TravelGuideCategoriesModel>> = MutableLiveData()
    val error: MutableLiveData<Unit> = MutableLiveData()

    init {
        fetchMightNeedTheseTravelGuide()
        fetchTopPickArticlesTravelGuide()
        fetchChipGuide()
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

    private fun fetchChipGuide() {
        TravelGuideApi.retrofitService.getDataFromApiCategories()
            .enqueue(object : Callback<List<TravelGuideCategoriesModel>> {
                override fun onResponse(
                    call: Call<List<TravelGuideCategoriesModel>>,
                    response: Response<List<TravelGuideCategoriesModel>>
                ) {
                    response.body()
                        ?.let { responseList -> uiModelChip.value = responseList }
                    if (response.isSuccessful) {
                        uiModelChip.value = response.body()
                    } else {
                        error.value = Unit
                    }
                }

                override fun onFailure(call: Call<List<TravelGuideCategoriesModel>>, t: Throwable) {
                    Log.v("ERROR", t.message.toString())
                    error.value = Unit
                }
            })
    }

}

