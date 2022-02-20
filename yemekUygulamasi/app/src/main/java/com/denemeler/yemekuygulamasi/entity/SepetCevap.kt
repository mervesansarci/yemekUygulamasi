package com.denemeler.yemekuygulamasi.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SepetCevap(@SerializedName("sepet_yemekler") @Expose var sepet_yemekler : List<Sepet> = arrayListOf(),
                       @SerializedName("succes") @Expose var succes: Int)