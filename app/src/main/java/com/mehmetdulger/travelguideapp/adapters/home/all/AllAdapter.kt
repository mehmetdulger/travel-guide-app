package com.mehmetdulger.travelguideapp.adapters.home.all

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.mehmetdulger.travelguideapp.R
import com.mehmetdulger.travelguideapp.TravelGuideModel
import com.mehmetdulger.travelguideapp.viewholder.home.all.AllViewHolder

class AllAdapter(
    private var list: List<TravelGuideModel>,
    private val onItemClickHandler: (travelGuideModel: TravelGuideModel) -> Unit
):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val travelGuideModelBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.all_row, parent, false)
        return AllViewHolder(travelGuideModelBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AllViewHolder).onBind(list.get(position) , onItemClickHandler)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}