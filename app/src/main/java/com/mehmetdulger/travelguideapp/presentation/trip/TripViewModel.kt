package com.mehmetdulger.travelguideapp.presentation.trip

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class TripViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Trip Plan"
    }
    val text: LiveData<String> = _text
}