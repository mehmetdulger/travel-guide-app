package com.mehmetdulger.travelguideapp.ui.home.transportations

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.TravelGuideApi
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.FragmentTransportationsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransportationsFragment : Fragment() {

    private lateinit var fragmentTransportationsBinding: FragmentTransportationsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTransportationsBinding = FragmentTransportationsBinding.inflate(inflater, container, false)
        return fragmentTransportationsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TravelGuideApi.retrofitService.getDataFromApi("transportation")
            .enqueue(object : Callback<List<TravelGuideModel>> {
                override fun onResponse(
                    call: Call<List<TravelGuideModel>>,
                    response: Response<List<TravelGuideModel>>
                ) {
                    response.body()?.let { responseList ->

                        val adapterTransportations =
                            TransportationsAdapter(responseList) { item ->
                                // val action =
                                //   HomeFragmentDirections.actionNavigationHomeToDetailFragment()
                                // findNavController().navigate(action)
                            }
                        val linearLayoutManager_horizontal = LinearLayoutManager(
                            context,
                            RecyclerView.HORIZONTAL,
                            false
                        )

                        fragmentTransportationsBinding.apply {
                            transportationsRecyclerView.layoutManager =
                                linearLayoutManager_horizontal
                            setVariable(BR.transportationsAdapter, adapterTransportations)
                        }
                    }
                }

                override fun onFailure(call: Call<List<TravelGuideModel>>, t: Throwable) {
                    Log.v("ERROR", t.message.toString())
                }

            })
    }

}