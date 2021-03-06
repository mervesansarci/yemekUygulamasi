package com.denemeler.yemekuygulamasi.entity

import androidx.core.app.NotificationCompat
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.io.SerializablePermission

data class Sepet(@SerializedName("sepet_yemek_id") @Expose var sepet_yemek_id : Int,
                 @SerializedName("yemek_adi") @Expose var yemek_adi : String,
                 @SerializedName("yemek_resim_adi") @Expose var yemek_resim_adi : String,
                 @SerializedName("yemek_fiyat") @Expose var yemek_fiyat : Int,
                 @SerializedName("yemek_siparis_adet") @Expose var yemek_siparis_adet : Int,
                 @SerializedName("kullanici_adi") @Expose var kullanici_adi : String = "merve") : Serializable{}