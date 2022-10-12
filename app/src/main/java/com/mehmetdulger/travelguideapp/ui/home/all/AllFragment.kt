package com.mehmetdulger.travelguideapp.ui.home.all

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.adapters.home.all.AllAdapter
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.FragmentAllBinding
import com.mehmetdulger.travelguideapp.ui.home.HomeFragmentDirections
import com.mehmetdulger.travelguideapp.presentation.home.all.AllViewModel

class AllFragment : Fragment() {

    private lateinit var fragmentAllBinding: FragmentAllBinding
    private lateinit var allViewModel: AllViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        allViewModel = ViewModelProvider(this)[AllViewModel::class.java]
        fragmentAllBinding = FragmentAllBinding.inflate(inflater, container, false)
        return fragmentAllBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        allViewModel.uiModelAll.observe(viewLifecycleOwner) {
            renderAllUi(it)
        }
        allViewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(context, "Bir hata oluştu !", Toast.LENGTH_SHORT).show()
        }
    }

    private fun renderAllUi(travelGuideModels: List<TravelGuideModel>) {
        val adapterAll = AllAdapter(travelGuideModels) { travelGuideModel ->
            navigateDetail(travelGuideModel)
        }
        fragmentAllBinding.apply {
            setVariable(BR.allAdapter, adapterAll)
        }
    }

    private fun navigateDetail(travelGuideModel: TravelGuideModel) {
        val action = HomeFragmentDirections.actionNavigationHomeToDetailFragment(travelGuideModel)
        findNavController().navigate(action)
    }

}
