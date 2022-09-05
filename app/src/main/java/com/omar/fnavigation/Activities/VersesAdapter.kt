package com.omar.fnavigation.Activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omar.fnavigation.databinding.ItemVerseBinding

class VersesAdapter(val verses: List<String>): RecyclerView.Adapter<VersesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val viewBinding = ItemVerseBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBinding.content.setText(verses[position] + " {${position + 1}}")
    }

    override fun getItemCount(): Int = verses.size

    class ViewHolder(val itemBinding: ItemVerseBinding):
            RecyclerView.ViewHolder(itemBinding.root)
}