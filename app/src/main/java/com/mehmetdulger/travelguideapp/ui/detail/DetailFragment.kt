package com.mehmetdulger.travelguideapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.mehmetdulger.travelguideapp.R
import com.mehmetdulger.travelguideapp.databinding.FragmentDetailBinding
import com.mehmetdulger.travelguideapp.databinding.FragmentGuideBinding

class DetailFragment : Fragment() {
    private lateinit var fragmentDetailBinding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentDetailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return fragmentDetailBinding.root
    }
}