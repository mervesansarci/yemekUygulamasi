package com.denemeler.yemekuygulamasi.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.denemeler.yemekuygulamasi.R
import com.denemeler.yemekuygulamasi.adapter.SepetUrunlerAdapter
import com.denemeler.yemekuygulamasi.adapter.YemeklerAdapter
import com.denemeler.yemekuygulamasi.databinding.FragmentSepetBinding
import com.denemeler.yemekuygulamasi.entity.Sepet
import com.denemeler.yemekuygulamasi.entity.Yemekler
import com.denemeler.yemekuygulamasi.viewmodel.SepetFragmentViewModel


class SepetFragment : Fragment() {

    private lateinit var tasarim:FragmentSepetBinding
    private lateinit var adapter:SepetUrunlerAdapter
    private lateinit var viewModel: SepetFragmentViewModel
    val sepetListesi = ArrayList<Sepet>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet,container,false)
        tasarim.sepetFragmentNesnesi = this
        tasarim.rvSepet.layoutManager = LinearLayoutManager(requireContext())
        sepetViewModel()


        tasarim.buttonSiparisOnay.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.sepetToOnay)
        }
        return tasarim.root
    }

    fun sepetViewModel(){


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : SepetFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
    }






}