package com.denemeler.yemekuygulamasi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denemeler.yemekuygulamasi.entity.Yemekler
import com.denemeler.yemekuygulamasi.repo.YemeklerDaoRepository

class AnasayfaFragmentViewModel: ViewModel() {
    var yemekListesi :  LiveData<List<Yemekler>>
    private var repo = YemeklerDaoRepository()

    init {
        yemekleriGetir()
        yemekListesi = repo.yemekleriGetir()
    }

    fun yemekleriGetir(){
        repo.tumYemekleriAl()
    }

}