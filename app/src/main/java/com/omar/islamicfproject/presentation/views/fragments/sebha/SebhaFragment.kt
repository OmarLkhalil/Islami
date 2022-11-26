package com.omar.islamicfproject.presentation.views.fragments.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.omar.islamicfproject.R
import com.omar.islamicfproject.databinding.FragmentSebhaBinding

class sebhaFragment :Fragment() {

    private lateinit var binding:FragmentSebhaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        binding =
            DataBindingUtil.inflate(inflater,
            R.layout.fragment_sebha,
            container, false)
        setHasOptionsMenu(true)



        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    lateinit var counter : Button
    lateinit var zekr : Button
    var generalCounter = 0
    var count =0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        counter=requireView().findViewById(R.id.counter)
        zekr=requireView().findViewById(R.id.zekr)

        counter.setOnClickListener {
            count++
            generalCounter++

            if (generalCounter == 30) {
                count = 0
                zekr.setText("استغفرالله")

            }else if (generalCounter==60){
                count =0
                zekr.setText("سبحان الله")

            }
            else if (generalCounter==90){
                count =0
                zekr.setText("لا اله الا الله")
            }
            else if (generalCounter==120){
                count =0
                zekr.setText("الله اكبر")
            }
            else if (generalCounter==150){
                count =0
                zekr.setText("سبحان الله و بحمده ")
            }
            else if (generalCounter==180){
                count =0
                zekr.setText("سبحان الله العظيم")
            }
            else if (generalCounter==210){
                count =0
                zekr.setText("لا حول و لا قوة الا بالله")
            }
            counter.setText(count.toString())


        }

    }
}