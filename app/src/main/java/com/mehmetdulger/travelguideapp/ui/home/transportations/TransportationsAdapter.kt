package com.mehmetdulger.travelguideapp.ui.home.transportations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.mehmetdulger.travelguideapp.R
import com.mehmetdulger.travelguideapp.TravelGuideModel

class TransportationsAdapter(
    private var list: List<TravelGuideModel>,
    private val onItemClickHandler: (travelGuideModel: TravelGuideModel) -> Unit
):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val travelGuideModelBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.transportations_row, parent, false)
        return TransportationsViewHolder(travelGuideModelBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TransportationsViewHolder).onBind(list.get(position) , onItemClickHandler)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}