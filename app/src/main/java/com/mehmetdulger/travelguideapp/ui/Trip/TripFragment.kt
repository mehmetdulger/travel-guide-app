package com.mehmetdulger.travelguideapp.ui.guide

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.mehmetdulger.travelguideapp.databinding.FragmentTripBinding
import com.mehmetdulger.travelguideapp.ui.Trip.CustomViewPager


class TripFragment : Fragment() {

    private lateinit var fragmentTripBinding: FragmentTripBinding
    private val tabIcons = intArrayOf(
        R.drawable.ic_menu_today,
        R.drawable.ic_btn_speak_now
    )


    // This property is only valid between onCreateView and
    // onDestroyView.
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

        fragmentTripBinding.addTripButton.setOnClickListener { onClick(it) }


    val viewPager = fragmentTripBinding.tripViewPager
    viewPager.adapter = CustomViewPager(fm = parentFragmentManager)

    tabLayout = fragmentTripBinding.tabLayout
    tabLayout.setupWithViewPager(viewPager)
    setupTabIcons()

}

private fun setupTabIcons() {
    tabLayout.getTabAt(0)!!.setIcon(tabIcons.get(0))
    tabLayout.getTabAt(1)!!.setIcon(tabIcons.get(1))
}

fun onClick(v: View) {
    val buttonClick = AlphaAnimation(1f, 0.5f)
    v.startAnimation(buttonClick)
}


/* private val navIcons = intArrayOf(
     R.drawable.button_onoff_indicator_off,
     R.drawable.ico_search,
 )
 private val navLabels = intArrayOf(
     R.string.nav_home,
     R.string.nav_search,
 )

 private val navIconsActive = intArrayOf(
     R.drawable.ico_home_red,
     R.drawable.ico_search_red,
 )
*/
}