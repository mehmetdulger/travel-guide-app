package com.mehmetdulger.travelguideapp.ui.Trip.Trips

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mehmetdulger.travelguideapp.databinding.FragmentTripsBinding

class TripsFragment : Fragment() {
    private lateinit var fragmentTripsBinding: FragmentTripsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTripsBinding = FragmentTripsBinding.inflate(inflater, container, false)
        return fragmentTripsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}