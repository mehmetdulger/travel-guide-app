package com.mehmetdulger.travelguideapp.ui.guide

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.TravelGuideApi
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.FragmentGuideBinding
import com.mehmetdulger.travelguideapp.databinding.FragmentSearchBinding
import com.mehmetdulger.travelguideapp.ui.search.SearchViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GuideFragment : Fragment() {

    private lateinit var fragmentGuideBinding: FragmentGuideBinding
    private lateinit var guideViewModel: GuideViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        guideViewModel = ViewModelProvider(this)[GuideViewModel::class.java]
        fragmentGuideBinding = FragmentGuideBinding.inflate(inflater, container, false)
        return fragmentGuideBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
    }


    private fun observeViewModel() {
        guideViewModel.uiModelMightNeedThese.observe(viewLifecycleOwner) {
            renderMightNeedTheseUi(it)
        }
        guideViewModel.uiModelTopPickArticles.observe(viewLifecycleOwner) {
            renderTopPickArticlesUi(it)
        }
        guideViewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(context, "Bir hata oluştu !", Toast.LENGTH_SHORT).show()
        }
    }
    private fun renderMightNeedTheseUi(travelGuideModels: List<TravelGuideModel>){
        val adapterMightNeedThese = MightNeedTheseAdapter(travelGuideModels){travelGuideModel ->
            navgateDetail(travelGuideModel)
        }
        fragmentGuideBinding.apply {
            setVariable(BR.mightNeedTheseAdapter,adapterMightNeedThese)
        }
    }

    private fun renderTopPickArticlesUi(travelGuideModels: List<TravelGuideModel>){
        val adapterTopPickArticles = TopPickArticlerAdapter(travelGuideModels){travelGuideModel ->
            navgateDetail(travelGuideModel)
        }

        fragmentGuideBinding.apply {
            setVariable(BR.topPickArticlesAdapter,adapterTopPickArticles)
        }
    }
    private fun navgateDetail(travelGuideModel: TravelGuideModel){
        val action = GuideFragmentDirections.actionNavigationGuideToDetailFragment(travelGuideModel)
        findNavController().navigate(action)
    }

























}
