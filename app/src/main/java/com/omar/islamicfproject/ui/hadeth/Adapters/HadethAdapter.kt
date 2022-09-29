package com.omar.islamicfproject.ui.hadeth.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.omar.islamicfproject.R


class HadethAdapter(val items:List <String>) : RecyclerView.Adapter<HadethAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val suraName = items.get(position)
        holder.name.setText(suraName)
        if (onItemCLickListener != null) {
            holder.itemView.setOnClickListener {
                onItemCLickListener?.onItemClick(position, suraName);
            }
        }

    }

    override fun getItemCount(): Int = items.size;

    var onItemCLickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(pos: Int, name: String)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.item)
    }
}