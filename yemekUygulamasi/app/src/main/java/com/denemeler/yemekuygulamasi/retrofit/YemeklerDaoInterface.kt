package com.denemeler.yemekuygulamasi.retrofit

import com.denemeler.yemekuygulamasi.entity.CRUDCevap
import com.denemeler.yemekuygulamasi.entity.SepetCevap
import com.denemeler.yemekuygulamasi.entity.Yemekler
import com.denemeler.yemekuygulamasi.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemeklerDaoInterface {

    @GET ("yemekler/tumYemekleriGetir.php")
    fun tumYemekler() : Call<YemeklerCevap>


    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun siparisEkle(@Field("yemek_adi") yemek_adi:String,
                 @Field("yemek_resim_adi") yemek_resim_adi: String,
                 @Field("yemek_fiyat") yemek_fiyat: Int,
                 @Field("yemek_siparis_adet") yemek_siparis_adet: Int,
                 @Field("kullanici_adi") kullanici_adi: String) : Call<CRUDCevap>

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun tumSiparisler(@Field("kullanici_adi") kullanici_adi:String) : Call<SepetCevap>

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun siparisSil(@Field("sepet_yemek_id") sepet_yemek_id:Int,
                    @Field("kullanici_adi") kullanici_adi:String) : Call<CRUDCevap>
}
