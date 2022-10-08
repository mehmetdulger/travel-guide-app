package com.mehmetdulger.travelguideapp.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mehmetdulger.travelguideapp.ui.home.all.AllFragment
import com.mehmetdulger.travelguideapp.ui.home.flights.FlightsFragment
import com.mehmetdulger.travelguideapp.ui.home.hotels.HotelsFragment
import com.mehmetdulger.travelguideapp.ui.home.transportations.TransportationsFragment


class HomePageViewPager(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 4;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {

                return AllFragment()
            }
            1 -> {
                return FlightsFragment()
            }
            2 -> {

                return HotelsFragment()
            }
            3 -> {
                return TransportationsFragment()
            }
            else -> {
                return AllFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "All"
            }
            1 -> {
                return "Flights"
            }
            2 -> {
                return "Hotels"
            }
            3 -> {
                return "Transportations"
            }
        }
        return super.getPageTitle(position)
    }

}