package com.omar.islamicfproject.ui.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.omar.islamicfproject.databinding.FragmentRadioBinding

class radioFragment : Fragment() {

    private val binding : FragmentRadioBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = binding?.root
        return root
    }
}