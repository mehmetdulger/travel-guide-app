package com.mehmetdulger.travelguideapp.ui.home.hotels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.adapters.home.hotels.HotelsAdapter
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.FragmentHotelsBinding
import com.mehmetdulger.travelguideapp.ui.home.HomeFragmentDirections
import com.mehmetdulger.travelguideapp.presentation.home.hotels.HotelsViewModel

class HotelsFragment : Fragment() {

    private lateinit var fragmentHotelsBinding: FragmentHotelsBinding
    private lateinit var hotelsBinding: HotelsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        hotelsBinding = ViewModelProvider(this)[HotelsViewModel::class.java]
        fragmentHotelsBinding = FragmentHotelsBinding.inflate(inflater, container, false)
        return fragmentHotelsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
    }

    private fun observeViewModel() {
        hotelsBinding.uiModelHotels.observe(viewLifecycleOwner) {
            renderHotelsUi(it)
        }
        hotelsBinding.error.observe(viewLifecycleOwner) {
            Toast.makeText(context, "Bir hata oluştu !", Toast.LENGTH_SHORT).show()
        }
    }

    private fun renderHotelsUi(travelGuideModels: List<TravelGuideModel>) {
        val adapterHotels = HotelsAdapter(travelGuideModels) { travelGuideModel ->
            navigateDetail(travelGuideModel)
        }
        fragmentHotelsBinding.apply {
            setVariable(BR.hotelsAdapter, adapterHotels)
        }
    }

    private fun navigateDetail(travelGuideModel: TravelGuideModel) {
        val action = HomeFragmentDirections.actionNavigationHomeToDetailFragment(travelGuideModel)
        findNavController().navigate(action)
    }

}
