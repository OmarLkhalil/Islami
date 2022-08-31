package com.omar.fnavigation.UI.quran.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omar.fnavigation.R
import android.widget.TextView

class quranAdapter (private val mList: List<String>) :
    RecyclerView.Adapter<quranAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sura_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val suraName = mList.get(position)
        holder.textView.setText(suraName)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView : TextView = itemView.findViewById(R.id.header_title)
    }
}