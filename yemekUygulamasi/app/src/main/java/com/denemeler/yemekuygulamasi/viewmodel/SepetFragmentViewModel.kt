package com.denemeler.yemekuygulamasi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.denemeler.yemekuygulamasi.entity.Sepet

class SepetFragmentViewModel : ViewModel(){
    val repo = YemekDetayViewModel()
    //val sepetListesi : LiveData<List<Sepet>>

    init {
        //sepetListesi = repo.
    }

    fun sepetListesiniGetir(){
        //
    }


}