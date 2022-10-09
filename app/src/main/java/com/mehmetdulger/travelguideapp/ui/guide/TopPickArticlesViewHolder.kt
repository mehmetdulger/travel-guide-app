package com.mehmetdulger.travelguideapp.ui.guide


import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.TopDestinationRowBinding
import com.mehmetdulger.travelguideapp.databinding.TopPickArticlesRowBinding

class TopPickArticlesViewHolder(
    private val travelGuideBinding: ViewDataBinding,
) : RecyclerView.ViewHolder(travelGuideBinding.root) {
    fun onBind(
        travelGuideModel: TravelGuideModel,
        onItemClickHandler: (travelGuideModel: TravelGuideModel) -> Unit
    ) {
        val binding = travelGuideBinding as TopPickArticlesRowBinding
        binding.root.setOnClickListener { onItemClickHandler(travelGuideModel) }

        binding.topPickArticlesImageView.load(travelGuideModel.images!![0].url!!)

        binding.topPickArticlesImageView.setOnClickListener {
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