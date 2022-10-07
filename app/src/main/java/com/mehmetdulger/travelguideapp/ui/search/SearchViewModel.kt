package com.mehmetdulger.travelguideapp.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.FragmentSearchBinding

class SearchViewModel : ViewModel() {
    lateinit var travelGuideModel: MutableLiveData<TravelGuideModel?>
    private lateinit var fragmentSearchBinding: FragmentSearchBinding


    init {
        travelGuideModel = MutableLiveData()
    }

    fun getTravelGuideDataObserver(): MutableLiveData<TravelGuideModel?> {
        return travelGuideModel
    }


}