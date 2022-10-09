package com.mehmetdulger.travelguideapp.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var fragmentSearchBinding: FragmentSearchBinding
    private lateinit var searchViewModel:SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        fragmentSearchBinding = FragmentSearchBinding.inflate(inflater, container, false)
        return fragmentSearchBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()

    }

    private fun observeViewModel(){
        searchViewModel.uiModelTopDestination.observe(viewLifecycleOwner) {
            renderTopDestinationUi(it)
        }
        searchViewModel.uiModelNearbyAttraction.observe(viewLifecycleOwner) {
            renderNearbyAttractionUi(it)
        }
        searchViewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(context,"Bir hata oluştu !",Toast.LENGTH_SHORT).show()
        }
    }
    private fun renderTopDestinationUi(travelGuideModels: List<TravelGuideModel>){
        val adapter = TopDestinationAdapter(travelGuideModels){ travelGuideModel ->
            navigateDetail(travelGuideModel)
        }
        fragmentSearchBinding.apply {
            setVariable(BR.topDestinationAdapter,adapter)
        }
    }

    private fun renderNearbyAttractionUi(travelGuideModels: List<TravelGuideModel>){
        val adapterNearbyAttraction = NearbyAttractionAdapter(travelGuideModels) { travelGuideModel ->
            navigateDetail(travelGuideModel)
        }

        fragmentSearchBinding.apply {
            setVariable(BR.nearbyAttractionAdapter,adapterNearbyAttraction)
        }
    }

    private fun navigateDetail(travelGuideModel: TravelGuideModel){
        val action = SearchFragmentDirections.actionNavigationSearchToDetailFragment()
        findNavController().navigate(action)
    }

}
