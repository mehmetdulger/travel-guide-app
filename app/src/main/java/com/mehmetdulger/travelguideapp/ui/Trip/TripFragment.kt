package com.mehmetdulger.travelguideapp.ui.guide

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.mehmetdulger.travelguideapp.databinding.FragmentTripBinding
import com.mehmetdulger.travelguideapp.ui.Trip.CustomViewPager


class TripFragment : Fragment() {

    private lateinit var fragmentTripBinding: FragmentTripBinding
    lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTripBinding = FragmentTripBinding.inflate(inflater, container, false)
        return fragmentTripBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentTripBinding.addNewTripButton.setOnClickListener {
            onClick(it)
            val action = TripFragmentDirections.actionNavigationTripToAddTripFragment()
            findNavController().navigate(action)
        }

        val viewPager = fragmentTripBinding.tripViewPager
        viewPager.adapter = CustomViewPager(fm = parentFragmentManager)

        tabLayout = fragmentTripBinding.tabLayout
        tabLayout.setupWithViewPager(viewPager)
        setupTabIcons()
    }

    private fun setupTabIcons() {
        tabLayout.getTabAt(0)!!.setIcon(tabIcons[0])
        tabLayout.getTabAt(1)!!.setIcon(tabIcons[1])
    }
    private val tabIcons = intArrayOf(
        android.R.drawable.ic_menu_mapmode,
        android.R.drawable.ic_input_get
    )

   private fun onClick(v: View) {
        val buttonClick = AlphaAnimation(1f, 0.5f)
        v.startAnimation(buttonClick)
    }
}
