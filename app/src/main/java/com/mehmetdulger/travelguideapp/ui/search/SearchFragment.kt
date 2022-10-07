package com.mehmetdulger.travelguideapp.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mehmetdulger.travelguideapp.databinding.FragmentSearchBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

    private lateinit var fragmentSearchBinding: FragmentSearchBinding

    // This property is only valid between onCreateView and
    // onDestroyView.

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
                        val linearLayoutManager = LinearLayoutManager(
                            context,
                            RecyclerView.HORIZONTAL,
                            false
                        )
                        fragmentSearchBinding.apply {
                            topDestinationRecyclerView.layoutManager = linearLayoutManager
                            //topDestinationRecyclerView.addItemDecoration(SpacesItemDecoration(10))
                            setVariable(BR.adapter, adapter)
                        }
                    }
                }

                override fun onFailure(call: Call<List<TravelGuideModel>>, t: Throwable) {
                    Log.v("ERROR", t.message.toString())
                }

            })
    }

}