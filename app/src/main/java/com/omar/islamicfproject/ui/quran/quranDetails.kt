package com.omar.islamicfproject.ui.quran

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.omar.islamicfproject.Constants
import com.omar.islamicfproject.R
import com.omar.islamicfproject.ui.quran.Adapter.DetailsAdapter


class quranDetails : AppCompatActivity() {
    lateinit var titleTextView : TextView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: DetailsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        titleTextView =findViewById(R.id.title_text_view)
        initRecyclerView()
        val suraName:String = intent.getStringExtra(Constants.EXTRA_NAME) as String
        val suraPos:Int =intent.getIntExtra(Constants.EXTRA_POST,-1)
        titleTextView.setText(suraName)
        readSuraFile(suraPos)


    }

    private fun initRecyclerView() {
        recyclerView=findViewById(R.id.recycler_view)
        adapter= DetailsAdapter()
        recyclerView.adapter=adapter
    }

    fun readSuraFile(pos:Int){
        val fileName="${pos+1}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText()}
        val verses :List<String> =fileContent.split("\n");
        adapter.changeData(verses)


    }

}