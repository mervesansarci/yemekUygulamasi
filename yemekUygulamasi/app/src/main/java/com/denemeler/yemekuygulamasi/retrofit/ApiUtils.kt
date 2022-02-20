package com.denemeler.yemekuygulamasi.retrofit

class ApiUtils {

    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getYemeklerDaoInterface() : YemeklerDaoInterface{
            return  RetforitClient.getClient(BASE_URL).create(YemeklerDaoInterface::class.java)
        }



    }
}