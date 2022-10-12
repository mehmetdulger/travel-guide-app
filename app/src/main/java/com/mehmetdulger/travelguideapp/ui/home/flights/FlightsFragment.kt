package com.mehmetdulger.travelguideapp.ui.home.flights

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.adapters.home.flights.FlightsAdapter
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.FragmentFlightsBinding
import com.mehmetdulger.travelguideapp.presentation.home.flights.FlightsViewModel
import com.mehmetdulger.travelguideapp.ui.home.HomeFragmentDirections

class FlightsFragment : Fragment() {

    private lateinit var fragmentFlightsBinding: FragmentFlightsBinding
    private lateinit var flightsViewModel: FlightsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        flightsViewModel = ViewModelProvider(this)[FlightsViewModel::class.java]
        fragmentFlightsBinding = FragmentFlightsBinding.inflate(inflater, container, false)
        return fragmentFlightsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
    }

    private fun observeViewModel() {
        flightsViewModel.uiModelFlights.observe(viewLifecycleOwner) {
            renderFlightsUi(it)
        }
        flightsViewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(context, "Bir hata oluştu !", Toast.LENGTH_SHORT).show()
        }
    }

    private fun renderFlightsUi(travelGuideModels: List<TravelGuideModel>) {
        val adapterFlights = FlightsAdapter(travelGuideModels) { travelGuideModel ->
            navigateDetail(travelGuideModel)
        }
        fragmentFlightsBinding.apply {
            setVariable(BR.flightsAdapter, adapterFlights)
        }
    }

    private fun navigateDetail(travelGuideModel: TravelGuideModel) {
        val action = HomeFragmentDirections.actionNavigationHomeToDetailFragment(travelGuideModel)
        findNavController().navigate(action)
    }

}
