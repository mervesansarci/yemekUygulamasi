package com.denemeler.yemekuygulamasi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.denemeler.yemekuygulamasi.R
import com.denemeler.yemekuygulamasi.adapter.YemeklerAdapter
import com.denemeler.yemekuygulamasi.databinding.FragmentAnasayfaBinding
import com.denemeler.yemekuygulamasi.entity.Yemekler
import com.denemeler.yemekuygulamasi.viewmodel.AnasayfaFragmentViewModel


class AnasayfaFragment : Fragment() {

    private lateinit var tasarim: FragmentAnasayfaBinding
    private lateinit var adapter: YemeklerAdapter
    private val viewModel: AnasayfaFragmentViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)

        tasarim.anasayfaFragmentNesnesi = this
        tasarim.anasayfaToolbarBaslik = "Bugün Ne Yesem?"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)
        tasarim.rv.layoutManager = LinearLayoutManager(requireContext())
        yemeklerViewModel()
        return tasarim.root

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.yemekleriGetir()

    }
    fun yemeklerViewModel(){
        viewModel.yemekListesi.observe(viewLifecycleOwner,{
            val adapter = YemeklerAdapter(requireContext(), it, viewModel)
            tasarim.yemeklerAdapter = adapter
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.yemekleriGetir()
    }
}

