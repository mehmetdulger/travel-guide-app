package com.mehmetdulger.travelguideapp.viewholder.trip.bookmark

import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mehmetdulger.travelguideapp.BR
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.databinding.AddBookmarkRowBinding

class BookmarkViewHolder(

    private val travelGuideBinding: ViewDataBinding

) : RecyclerView.ViewHolder(travelGuideBinding.root) {
    fun onBind(
        travelGuideModel: TravelGuideModel,
        onItemClickHandler: (travelGuideModel: TravelGuideModel) -> Unit
    ) {
        val binding = travelGuideBinding as AddBookmarkRowBinding
        binding.root.setOnClickListener { onItemClickHandler(travelGuideModel) }

        binding.addBookmarkImageView.load(travelGuideModel.images!![1].url!!)

        binding.addBookmarkImageView.setOnClickListener {
            onItemClickHandler(travelGuideModel)
        }

        binding.setVariable(BR.travelGuideModel, travelGuideModel)
    }

}

private fun ImageView.load(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}


