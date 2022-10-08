package com.mehmetdulger.travelguideapp.ui.home.all

import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.AllRowBinding
import com.mehmetdulger.travelguideapp.databinding.TopDestinationRowBinding
import com.mehmetdulger.travelguideapp.databinding.TopPickArticlesRowBinding

class AllViewHolder(
    private val travelGuideBinding: ViewDataBinding,
) : RecyclerView.ViewHolder(travelGuideBinding.root) {
    fun onBind(
        travelGuideModel: TravelGuideModel,
        onItemClickHandler: (travelGuideModel: TravelGuideModel) -> Unit
    ) {
        val binding = travelGuideBinding as AllRowBinding
        binding.root.setOnClickListener { onItemClickHandler(travelGuideModel) }

        binding.allDealImageView.load(travelGuideModel.images[0].url)

        binding.allDealImageView.setOnClickListener {
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