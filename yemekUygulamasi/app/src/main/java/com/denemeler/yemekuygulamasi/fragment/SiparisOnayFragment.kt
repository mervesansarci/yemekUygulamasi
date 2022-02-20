package com.denemeler.yemekuygulamasi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.denemeler.yemekuygulamasi.R
import com.denemeler.yemekuygulamasi.databinding.FragmentSiparisOnayBinding
import com.denemeler.yemekuygulamasi.databinding.FragmentYemekDetayBinding


class SiparisOnayFragment : Fragment() {
    private lateinit var  tasarim: FragmentSiparisOnayBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentSiparisOnayBinding.inflate(inflater,container,false)


        return tasarim.root
    }

}