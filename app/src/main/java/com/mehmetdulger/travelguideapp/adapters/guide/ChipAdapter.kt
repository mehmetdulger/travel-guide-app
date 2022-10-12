package com.mehmetdulger.travelguideapp.adapters.guide

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.mehmetdulger.travelguideapp.R
import com.mehmetdulger.travelguideapp.TravelGuideCategoriesModel
import com.mehmetdulger.travelguideapp.viewholder.guide.ChipsViewHolder

class ChipAdapter(
    private var list: List<TravelGuideCategoriesModel>,
    private val onItemClickHandler: (travelGuideCategoriesModel: TravelGuideCategoriesModel) -> Unit
):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val travelGuideCategoriesModelBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.chip_row, parent, false)
        return ChipsViewHolder(travelGuideCategoriesModelBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ChipsViewHolder).onBind(list.get(position) , onItemClickHandler)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}