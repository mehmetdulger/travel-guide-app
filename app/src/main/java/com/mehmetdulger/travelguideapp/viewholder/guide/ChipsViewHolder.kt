package com.mehmetdulger.travelguideapp.viewholder.guide

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.R
import com.mehmetdulger.travelguideapp.TravelGuideCategoriesModel
import com.mehmetdulger.travelguideapp.databinding.ChipRowBinding


class ChipsViewHolder(
    private val travelGuideBinding: ViewDataBinding,
) : RecyclerView.ViewHolder(travelGuideBinding.root) {
    fun onBind(
        travelGuideCategoriesModel: TravelGuideCategoriesModel,
        onItemClickHandler: (travelGuideModel: TravelGuideCategoriesModel) -> Unit
    ) {
        val binding = travelGuideBinding as ChipRowBinding
        binding.root.setOnClickListener { onItemClickHandler(travelGuideCategoriesModel) }

        val chipsIconResource = when (travelGuideCategoriesModel.icon) {
            "taxi" -> R.drawable.ic_taxi_icon_chip
            "restaurant" -> R.drawable.ic_restaurant_icon_chip
            "rentcar" -> R.drawable.ic_rentcar_icon_chip
            "museum" -> R.drawable.ic_museum_icon_chip
            "resort" -> R.drawable.ic_resort_icon_chip
            "sightseeing" -> R.drawable.ic_sightseeing_icon_chip
            "mall"->R.drawable.ic_mall_icon_chip
            else -> R.drawable.ic_launcher_background
        }
        binding.chipRow.setChipIconResource(chipsIconResource)
        binding.chipRow.chipBackgroundColor

        binding.setVariable(BR.travelGuideCategriesModel, travelGuideCategoriesModel)
    }

}
