package com.mehmetdulger.travelguideapp.ui.home

import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mehmetdulger.travelguideapp.*
import com.mehmetdulger.travelguideapp.ui.Trip.Bookmark.BookmarkFragment
import com.mehmetdulger.travelguideapp.ui.Trip.Trips.TripsFragment
import kotlinx.coroutines.internal.artificialFrame
import kotlin.time.toDuration


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