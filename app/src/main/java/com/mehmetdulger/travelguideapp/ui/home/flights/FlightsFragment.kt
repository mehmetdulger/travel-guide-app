package com.mehmetdulger.travelguideapp.ui.home.flights

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.R
import com.mehmetdulger.travelguideapp.TravelGuideApi
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.FragmentAllBinding
import com.mehmetdulger.travelguideapp.databinding.FragmentFlightsBinding
import com.mehmetdulger.travelguideapp.ui.home.all.AllAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlightsFragment : Fragment() {

    private lateinit var fragmentFlightsBinding: FragmentFlightsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFlightsBinding = FragmentFlightsBinding.inflate(inflater, container, false)
        return fragmentFlightsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TravelGuideApi.retrofitService.getDataFromApi("flight")
            .enqueue(object : Callback<List<TravelGuideModel>> {
                override fun onResponse(
                    call: Call<List<TravelGuideModel>>,
                    response: Response<List<TravelGuideModel>>
                ) {
                    response.body()?.let { responseList ->

                        val adapterFlights =
                            FlightsAdapter(responseList) { item ->
                                // val action =
                                //   HomeFragmentDirections.actionNavigationHomeToDetailFragment()
                                // findNavController().navigate(action)
                            }
                        val linearLayoutManager_horizontal = LinearLayoutManager(
                            context,
                            RecyclerView.HORIZONTAL,
                            false
                        )

                        fragmentFlightsBinding.apply {
                            flightsRecyclerView.layoutManager =
                                linearLayoutManager_horizontal
                            setVariable(BR.flightsAdapter, adapterFlights)
                        }
                    }
                }

                override fun onFailure(call: Call<List<TravelGuideModel>>, t: Throwable) {
                    Log.v("ERROR", t.message.toString())
                }

            })
    }


}