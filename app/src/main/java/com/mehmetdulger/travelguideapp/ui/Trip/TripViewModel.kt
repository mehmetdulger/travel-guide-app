package com.mehmetdulger.travelguideapp.ui.guide

import android.R
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView


class TripViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Trip Plan"
    }
    val text: LiveData<String> = _text
}