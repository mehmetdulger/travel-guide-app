package com.mehmetdulger.travelguideapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.mehmetdulger.travelguideapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var fragmentDetailBinding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentDetailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return fragmentDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = args.currentAllData.title
        val location = args.currentAllData.city
        val description = args.currentAllData.description
        val image = args.currentAllData.images!![0].url!!

        fragmentDetailBinding.apply {
            detailTitleTextView.text = title
            detailDescriptionTextView.text = description
            detailLocationTextView.text = location
            detailImageView.load(image)
        }


    }
    private fun ImageView.load(url: String) {
        Glide.with(context)
            .load(url)
            .into(this)
    }
}