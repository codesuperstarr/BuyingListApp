package com.example.buyinglistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.buyinglistapp.data.model.BuyingItems
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class BuyingListAdapter(
    var items: List<BuyingItems>): RecyclerView.Adapter<BuyingListAdapter.BuyingListViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyingListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return BuyingListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BuyingListViewHolder, position: Int) {
        val current = items[position]
        holder.itemView.textView.text = current.name
    }

    inner class BuyingListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

}
