package com.mehmetdulger.travelguideapp.ui.guide

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.TravelGuideApi
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.FragmentGuideBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GuideFragment : Fragment() {

    private lateinit var fragmentGuideBinding: FragmentGuideBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentGuideBinding = FragmentGuideBinding.inflate(inflater, container, false)
        return fragmentGuideBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TravelGuideApi.retrofitService.getDataFromApi("toppick")
            .enqueue(object : Callback<List<TravelGuideModel>> {
                override fun onResponse(
                    call: Call<List<TravelGuideModel>>,
                    response: Response<List<TravelGuideModel>>
                ) {
                    response.body()?.let { responseList ->

                        val adapterTopPickArticles =
                            TopPickArticlerAdapter(responseList) { item ->
                                val action =
                                    GuideFragmentDirections.actionNavigationGuideToDetailFragment()
                                findNavController().navigate(action)
                            }
                        val linearLayoutManager_horizontal = LinearLayoutManager(
                            context,
                            RecyclerView.HORIZONTAL,
                            false
                        )

                        fragmentGuideBinding.apply {
                            topPickArticlesRecyclerView.layoutManager =
                                linearLayoutManager_horizontal
                            setVariable(BR.topPickArticlesAdapter, adapterTopPickArticles)
                        }
                    }
                }

                override fun onFailure(call: Call<List<TravelGuideModel>>, t: Throwable) {
                    Log.v("ERROR", t.message.toString())
                }

            })


        TravelGuideApi.retrofitService.getDataFromApi("mightneed")
            .enqueue(object : Callback<List<TravelGuideModel>> {
                override fun onResponse(
                    call: Call<List<TravelGuideModel>>,
                    response: Response<List<TravelGuideModel>>
                ) {
                    response.body()?.let { responseList ->

                        val adapterMightNeedThese =
                            MightNeedTheseAdapter(responseList) { item ->
                                val action =
                                    GuideFragmentDirections.actionNavigationGuideToDetailFragment()
                                findNavController().navigate(action)
                            }
                        val linearLayoutManager_horizontal = LinearLayoutManager(
                            context,
                            RecyclerView.HORIZONTAL,
                            false
                        )

                        fragmentGuideBinding.apply {
                            mightNeedTheseRecyclerView.layoutManager =
                                linearLayoutManager_horizontal
                            setVariable(BR.mightNeedTheseAdapter, adapterMightNeedThese)
                        }
                    }
                }

                override fun onFailure(call: Call<List<TravelGuideModel>>, t: Throwable) {
                    Log.v("ERROR", t.message.toString())
                }

            })


    }
}