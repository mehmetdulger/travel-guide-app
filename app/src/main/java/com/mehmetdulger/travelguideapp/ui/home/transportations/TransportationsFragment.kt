package com.mehmetdulger.travelguideapp.ui.home.transportations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.adapters.home.transportations.TransportationsAdapter
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.FragmentTransportationsBinding
import com.mehmetdulger.travelguideapp.ui.home.HomeFragmentDirections
import com.mehmetdulger.travelguideapp.presentation.home.transportations.TrasnportationsViewModel

class TransportationsFragment : Fragment() {

    private lateinit var fragmentTransportationsBinding: FragmentTransportationsBinding
    private lateinit var transportationsViewModel: TrasnportationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        transportationsViewModel = ViewModelProvider(this)[TrasnportationsViewModel::class.java]
        fragmentTransportationsBinding = FragmentTransportationsBinding.inflate(inflater, container, false)
        return fragmentTransportationsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()

    }

    private fun observeViewModel(){
        transportationsViewModel.uiModelTransportations.observe(viewLifecycleOwner) {
            renderTransportationsUi(it)
        }
        transportationsViewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(context,"Bir hata oluştu !",Toast.LENGTH_SHORT).show()
        }
    }
    private fun renderTransportationsUi(travelGuideModels: List<TravelGuideModel>){
        val adapterTransportations = TransportationsAdapter(travelGuideModels){ travelGuideModel ->
            navigateDetail(travelGuideModel)
        }
        fragmentTransportationsBinding.apply {
            setVariable(BR.transportationsAdapter,adapterTransportations)
        }
    }


    private fun navigateDetail(travelGuideModel: TravelGuideModel){
        val action = HomeFragmentDirections.actionNavigationHomeToDetailFragment(travelGuideModel)
        findNavController().navigate(action)
    }

}
