package com.omar.islamicfproject.domain.adapters.hadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.omar.islamicfproject.R


class DetailsAdapter: RecyclerView.Adapter<DetailsAdapter.ViewHolder>() {
    var items :List<String>?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content=items?.get(position)
        holder.content.setText(content)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }
    fun changeData(verses:List<String>){
        this.items=verses
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val content: TextView = itemView.findViewById(R.id.item)
    }

}