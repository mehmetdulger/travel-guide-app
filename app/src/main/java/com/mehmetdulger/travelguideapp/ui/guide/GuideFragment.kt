package com.mehmetdulger.travelguideapp.ui.guide

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mehmetdulger.travelguideapp.R
import com.mehmetdulger.travelguideapp.databinding.FragmentGuideBinding

class GuideFragment : Fragment() {

    private lateinit var fragmentGuideBinding: FragmentGuideBinding

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(TripViewModel::class.java)
        fragmentGuideBinding = FragmentGuideBinding.inflate(inflater, container, false)
        return fragmentGuideBinding.root
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

    }

}