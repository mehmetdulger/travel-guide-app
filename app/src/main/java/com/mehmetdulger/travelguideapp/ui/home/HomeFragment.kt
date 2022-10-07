package com.mehmetdulger.travelguideapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.fragment.app.Fragment
import com.mehmetdulger.travelguideapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var fragmentHomeBinding: FragmentHomeBinding

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