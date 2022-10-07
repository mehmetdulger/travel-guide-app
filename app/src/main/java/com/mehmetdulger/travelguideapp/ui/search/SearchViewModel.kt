package com.mehmetdulger.travelguideapp.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide.init
import com.mehmetdulger.travelguideapp.databinding.FragmentSearchBinding
import retrofit2.Call
import java.net.URI.create
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.coroutineContext

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