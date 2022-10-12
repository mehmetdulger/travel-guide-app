package com.mehmetdulger.travelguideapp.ui.Trip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mehmetdulger.travelguideapp.R
import com.mehmetdulger.travelguideapp.databinding.FragmentAddTripBinding
import com.mehmetdulger.travelguideapp.databinding.FragmentSearchBinding

class AddTripFragment : Fragment() {
private lateinit var fragmentAddTripBinding: FragmentAddTripBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentAddTripBinding = FragmentAddTripBinding.inflate(inflater, container, false)
        return fragmentAddTripBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentAddTripBinding.addTripButton.setOnClickListener{
        }
    }


}