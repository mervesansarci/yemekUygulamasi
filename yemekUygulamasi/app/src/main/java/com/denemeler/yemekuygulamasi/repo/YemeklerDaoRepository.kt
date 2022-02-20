package com.denemeler.yemekuygulamasi.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.denemeler.yemekuygulamasi.entity.CRUDCevap
import com.denemeler.yemekuygulamasi.entity.Sepet
import com.denemeler.yemekuygulamasi.entity.Yemekler
import com.denemeler.yemekuygulamasi.entity.YemeklerCevap
import com.denemeler.yemekuygulamasi.retrofit.ApiUtils
import com.denemeler.yemekuygulamasi.retrofit.YemeklerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerDaoRepository {

    var yemekListesi:MutableLiveData<List<Yemekler>>
    var sepetListesi: MutableLiveData<List<Sepet>>
    var fdao :YemeklerDaoInterface = ApiUtils.getYemeklerDaoInterface()

    init {
        yemekListesi = MutableLiveData()
        sepetListesi = MutableLiveData()
    }

    fun yemekleriGetir() : LiveData<List<Yemekler>> {
        return yemekListesi
    }
    fun sepettekileriGetir() : MutableLiveData<List<Sepet>>{
        return sepetListesi
    }

    fun sepettekiYemekleriGetir(kullanici_adi:String){


    }
    fun sepeteEkle(yemek_adi:String, yemek_resim_adi: String, yemek_fiyat: Int, yemek_siparis_adet: Int, kullanici_adi: String){
        fdao.siparisEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                Log.e("sepet", " sepete eklendi")
            }
            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {} })
    }

    fun sepettenYemekSil(){

    }

    fun tumYemekleriAl(){
        fdao.tumYemekler().enqueue(object : Callback<YemeklerCevap>{

            override fun onResponse(call: Call<YemeklerCevap>, response: Response<YemeklerCevap>) {
                val liste = response.body().yemekler as ArrayList<Yemekler>
                yemekListesi.postValue(liste)

            }

            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}

        })

    }



}