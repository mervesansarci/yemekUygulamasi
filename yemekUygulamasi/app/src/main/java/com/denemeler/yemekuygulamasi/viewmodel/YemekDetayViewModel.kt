package com.denemeler.yemekuygulamasi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denemeler.yemekuygulamasi.repo.YemeklerDaoRepository

class YemekDetayViewModel : ViewModel(){


    var repo = YemeklerDaoRepository()
    var mSiparisSayi = MutableLiveData<Int>()
    var siparisSayi : LiveData<Int> = mSiparisSayi
    var mToplamTutar = MutableLiveData<Int>()
    var toplamTutar : LiveData<Int> = mToplamTutar


    fun buttonArttirTikla(adet:String , tutar: String){
        val yemekSiparisAdeti = adet.toInt()+1
        val toplamTutar = adet.toInt()* yemekSiparisAdeti
        mSiparisSayi.postValue(yemekSiparisAdeti)
        mToplamTutar.postValue(toplamTutar)

    }

    fun buttonAzaltTikla(adet:String , tutar: String){
        var yemekSiparisAdeti = adet.toInt()

        if(yemekSiparisAdeti>1 ){
            yemekSiparisAdeti = yemekSiparisAdeti-1
        }
        else if(yemekSiparisAdeti  == 0){yemekSiparisAdeti = 1}


        var toplamTutar  = tutar.toInt()*yemekSiparisAdeti
        mSiparisSayi.postValue(yemekSiparisAdeti)
        mToplamTutar.postValue(toplamTutar )

    }


    fun sepeteEkleTikla(yemek_adi:String, yemek_resim_adi: String, yemek_fiyat: Int, yemek_siparis_adet: Int, kullanici_adi: String){
        repo.sepeteEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
    }


}