package com.denemeler.yemekuygulamasi.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.denemeler.yemekuygulamasi.entity.*
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

        fdao.tumSiparisler(kullanici_adi).enqueue(object : Callback<SepetCevap>{
            override fun onResponse(call: Call<SepetCevap>, response: Response<SepetCevap>) {
                val list = response.body().sepet_yemekler as ArrayList<Sepet>
                sepetListesi.postValue(list)
            }
            override fun onFailure(call: Call<SepetCevap>?, t: Throwable?) {}

        })


    }
    fun sepeteEkle(yemek_adi:String, yemek_resim_adi: String, yemek_fiyat: Int, yemek_siparis_adet: Int, kullanici_adi: String){
        fdao.siparisEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
            }
            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {} })
    }

    fun sepettenYemekSil(sepet_yemek_id:Int, kullanici_adi: String){
        fdao.siparisSil(sepet_yemek_id,kullanici_adi).enqueue(object :Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                sepettekiYemekleriGetir(kullanici_adi)
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
            }
        })

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