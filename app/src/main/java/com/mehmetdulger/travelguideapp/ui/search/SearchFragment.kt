package com.mehmetdulger.travelguideapp.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.TravelGuideApi
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.FragmentSearchBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

    private lateinit var fragmentSearchBinding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)

        fragmentSearchBinding = FragmentSearchBinding.inflate(inflater, container, false)
        return fragmentSearchBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TravelGuideApi.retrofitService.getDataFromApi()
            .enqueue(object : Callback<List<TravelGuideModel>> {
                override fun onResponse(
                    call: Call<List<TravelGuideModel>>,
                    response: Response<List<TravelGuideModel>>
                ) {
                    response.body()?.let { responseList ->
                        val adapter = TopDestinationAdapter(responseList) { item ->
                            val action =
                                SearchFragmentDirections.actionNavigationSearchToDetailFragment()
                            findNavController().navigate(action)
                        }

                        val linearLayoutManager_Horizontal = LinearLayoutManager(
                            context,
                            RecyclerView.HORIZONTAL,
                            false
                        )
                        val adapterNearbyAttraction =
                            NearbyAttractionAdapter(responseList) { item ->
                                val action =
                                    SearchFragmentDirections.actionNavigationSearchToDetailFragment()
                                findNavController().navigate(action)
                            }
                        val linearLayoutManager_Vertical = LinearLayoutManager(
                            context,
                            RecyclerView.VERTICAL,
                            false
                        )

                        fragmentSearchBinding.apply {
                            topDestinationRecyclerView.layoutManager =
                                linearLayoutManager_Horizontal
                            setVariable(BR.topDestinationAdapter, adapter)

                            nearbyAttractionsRecyclerView.layoutManager =
                                linearLayoutManager_Vertical
                            setVariable(BR.nearbyAttractionAdapter, adapterNearbyAttraction)
                        }
                    }
                }

                override fun onFailure(call: Call<List<TravelGuideModel>>, t: Throwable) {
                    Log.v("ERROR", t.message.toString())
                }

            })

    }

}