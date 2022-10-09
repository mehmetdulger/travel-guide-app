package com.mehmetdulger.travelguideapp.ui.search

import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.TopDestinationRowBinding

class TopDestinationViewHolder(
    private val travelGuideBinding: ViewDataBinding,
) : RecyclerView.ViewHolder(travelGuideBinding.root) {
    fun onBind(
        travelGuideModel: TravelGuideModel,
        onItemClickHandler: (travelGuideModel: TravelGuideModel) -> Unit
    ) {
        val binding = travelGuideBinding as TopDestinationRowBinding
        binding.root.setOnClickListener { onItemClickHandler(travelGuideModel) }

        binding.topDestinationImageView.load(travelGuideModel.images!![0].url!!)

        binding.topDestinationImageView.setOnClickListener {
            onItemClickHandler(travelGuideModel)
        }

        binding.setVariable(BR.travelGuideModel, travelGuideModel)
    }

    private fun ImageView.load(url: String) {
        Glide.with(context)
            .load(url)
            .into(this)
    }


}