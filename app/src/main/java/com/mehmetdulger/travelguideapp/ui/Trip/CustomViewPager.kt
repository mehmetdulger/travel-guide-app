package com.mehmetdulger.travelguideapp.ui.Trip

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mehmetdulger.travelguideapp.ui.Trip.Bookmark.BookmarkFragment
import com.mehmetdulger.travelguideapp.ui.Trip.Trips.TripsFragment


class CustomViewPager(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 2;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return TripsFragment()
            }
            1 -> {
                return BookmarkFragment()
            }
            else -> {
                return TripsFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Trips"
            }
            1 -> {
                return "Bookmark"
            }
        }
        return super.getPageTitle(position)
    }

}