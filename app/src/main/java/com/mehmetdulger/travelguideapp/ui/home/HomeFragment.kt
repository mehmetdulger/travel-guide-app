package com.mehmetdulger.travelguideapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.mehmetdulger.travelguideapp.databinding.FragmentHomeBinding
import com.mehmetdulger.travelguideapp.ui.Trip.CustomViewPager

class HomeFragment : Fragment() {

    lateinit var fragmentHomeBinding: FragmentHomeBinding
    lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickEfect()

        val viewPager = fragmentHomeBinding.homeViewPager
        viewPager.adapter = HomePageViewPager(fm = parentFragmentManager)


        tabLayout = fragmentHomeBinding.homePageTabLayout
        tabLayout.setupWithViewPager(viewPager)
        setupTabIcons()

    }
    private fun setupTabIcons() {
        tabLayout.getTabAt(0)
        tabLayout.getTabAt(1)
        tabLayout.getTabAt(2)
        tabLayout.getTabAt(3)
    }
    private fun clickEfect(){
        fragmentHomeBinding.apply {
            flightsImageView.setOnClickListener {
                onClick(it)
            }
            hotelsImageView.setOnClickListener{
                onClick(it)
            }
            carsImageView.setOnClickListener{
                onClick(it)
            }
            taxiImageView.setOnClickListener{
                onClick(it)
            }
        }

    }
    fun onClick(v: View) {
        val buttonClick = AlphaAnimation(1f, 0.5f)
        v.startAnimation(buttonClick)
    }

}