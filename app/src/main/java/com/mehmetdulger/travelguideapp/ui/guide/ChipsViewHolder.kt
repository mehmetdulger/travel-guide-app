package com.mehmetdulger.travelguideapp.ui.guide

import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.R
import com.mehmetdulger.travelguideapp.TravelGuideCategoriesModel
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.ChipRowBinding
import com.mehmetdulger.travelguideapp.databinding.TopDestinationRowBinding
import com.mehmetdulger.travelguideapp.databinding.TopPickArticlesRowBinding

class ChipsViewHolder(
    private val travelGuideBinding: ViewDataBinding,
) : RecyclerView.ViewHolder(travelGuideBinding.root) {
    fun onBind(
        travelGuideCategoriesModel: TravelGuideCategoriesModel,
        onItemClickHandler: (travelGuideModel: TravelGuideCategoriesModel) -> Unit
    ) {
        val binding = travelGuideBinding as ChipRowBinding
        binding.root.setOnClickListener { onItemClickHandler(travelGuideCategoriesModel) }

        binding.setVariable(BR.travelGuideCategriesModel, travelGuideCategoriesModel)
    }

    private fun ImageView.load(url: String) {
        Glide.with(context)
            .load(url)
            .into(this)
    }
}