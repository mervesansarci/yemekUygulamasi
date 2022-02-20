package com.denemeler.yemekuygulamasi.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class YemeklerCevap(@SerializedName("yemekler") @Expose var yemekler : List<Yemekler>,
                         @SerializedName("succes") @Expose var succes: Int)
