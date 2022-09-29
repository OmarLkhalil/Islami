package com.omar.islamicfproject.ui.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.omar.islamicfproject.Constants
import com.omar.islamicfproject.R
import com.omar.islamicfproject.databinding.FragmentHadethBinding
import com.omar.islamicfproject.ui.hadeth.Adapters.HadethAdapter

class hadethFragment: Fragment() {

    val chaptersNames = listOf(
        "الحد يث الأول",
        "الحد يث الثاني",
        "الحد يث الـثـالـث",
        "الحد يث الـرابع",
        "الحد يث الخامس",
        "الحد يث السادس",
        "الحد يث السابع",
        "الحد يث الثامن",
        "الحديث التاسع",
        "الحديث العاشر",
        "الحديث الحادي عشر",
        "الحد يث الثاني عشر",
        "الحد يث الثالث عشر",
        "الحد يث الرابع عشر",
        "الحد يث الخامس عشر",
        "الحديث السادس عشر",
        "الحديث السابع عشر",
        "الحديث الثامن عشر",
        "الحد يث التاسع عشر",
        "الحد يث العشرون",
        "الحديث الواحد والعشرون",
        "الحديث الثاني والعشرون",
        "الحديث الثالث والعشرون",
        "الحديث الرابع والعشرون",
        "الحديث الخامس والعشرون",
        "الحديث السادس والعشرون",
        "الحديث السابع والعشرون",
        "الحديث الثامن والعشرون",
        "الحديث التاسع والعشرون",
        "الحديث الثلاثون"

    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran, container, false);
    }

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HadethAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    fun initRecyclerView() {
        recyclerView = requireView().findViewById(R.id.recycler_view)
        adapter = HadethAdapter(chaptersNames)
        adapter.onItemCLickListener = object : HadethAdapter.OnItemClickListener {
            override fun onItemClick(pos:Int, name:String) {
                showHadethDetails(pos,name)
            }
        }
        recyclerView.adapter = adapter
    }


    fun showHadethDetails(pos:Int,name:String) {
        val intent = Intent(requireActivity(),hadethDetails::class.java)
        intent.putExtra(Constants.EXTRA_NAME, name)
        intent.putExtra(Constants.EXTRA_POST, pos)
        startActivity(intent);

    }

}