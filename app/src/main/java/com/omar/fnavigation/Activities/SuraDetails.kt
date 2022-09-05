package com.omar.fnavigation.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.omar.fnavigation.Constants
import com.omar.fnavigation.R
import com.omar.fnavigation.databinding.ActivitySuraDetailsBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class SuraDetails : AppCompatActivity() {

    lateinit var binding: ActivitySuraDetailsBinding
    lateinit var versesList: List<String>
    lateinit var adapter: VersesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.appBar.back.setOnClickListener {
            onBackPressed()
        }

        val name: String = intent.getStringExtra(Constants.EXTRA_SURA_NAME) ?:""
        val pos: Int = intent.getIntExtra(Constants.EXTRA_SURA_POSITION, 0)
        readSura(pos)
        binding.content.suraName.text = name
        adapter = VersesAdapter(versesList)
        binding.content.recyclerView.adapter = adapter
    }

    fun readSura(pos: Int){
        val myLines = mutableListOf<String>()
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(InputStreamReader(assets.open("${pos + 1}.txt")))
            var mLine: String?
            while (reader.readLine().also { mLine = it } != null) {
                myLines.add(mLine!!);
            }
        } catch (e: IOException) {
            Log.e("sura-details", "error reading file");
        } finally {
            if (reader != null) {
                try {
                    reader.close()
                } catch (e: IOException) {
                }
            }
        }
        versesList = myLines;
    }
}