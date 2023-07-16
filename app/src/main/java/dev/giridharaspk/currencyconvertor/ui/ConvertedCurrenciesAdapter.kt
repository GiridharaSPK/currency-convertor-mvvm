package dev.giridharaspk.currencyconvertor.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.giridharaspk.currencyconvertor.R
import dev.giridharaspk.currencyconvertor.data.model.Rates
import dev.giridharaspk.currencyconvertor.databinding.GridItemLayoutBinding

class ConvertedCurrenciesAdapter(val list: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var rates: ArrayList<Rates> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ConvertedCurrencyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.grid_item_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is GridItemLayoutBinding) {
            holder.binding.apply {
                tvTitle.text = movieItem.title
                tvOverView.text = movieItem.overview
            }
        }
    }
}

internal class ConvertedCurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding: GridItemLayoutBinding = GridItemLayoutBinding.bind(itemView)
}