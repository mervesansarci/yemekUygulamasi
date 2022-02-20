package com.denemeler.yemekuygulamasi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.denemeler.yemekuygulamasi.R
import com.denemeler.yemekuygulamasi.databinding.SepetCardTasarimBinding
import com.denemeler.yemekuygulamasi.entity.Sepet
import com.denemeler.yemekuygulamasi.entity.Yemekler
import com.squareup.picasso.Picasso

class SepetUrunlerAdapter(var mContext: Context, var sepetListesi:List<Sepet>)
    : RecyclerView.Adapter<SepetUrunlerAdapter.SepetCardTasarimTutucu>() {


    inner class SepetCardTasarimTutucu(cardTasarimBinding: SepetCardTasarimBinding) : RecyclerView.ViewHolder(cardTasarimBinding.root){

        var cardTasarimBinding: SepetCardTasarimBinding

        init {
            this.cardTasarimBinding = cardTasarimBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetCardTasarimTutucu {


        val layoutInflater = LayoutInflater.from(mContext)

        val tasarim = SepetCardTasarimBinding.inflate(layoutInflater,parent,false)
        return SepetCardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: SepetCardTasarimTutucu, position: Int) {
        val sepet = sepetListesi.get(position)
        var yemekSiparisAdeti =1
        var yeniYemekFiyati = 0
        var t = holder.cardTasarimBinding
        t.sepetNesnesi = sepet
        val yemekAdi = sepet.yemek_resim_adi
        var url = "http://kasimadalan.pe.hu/yemekler/resimler/$yemekAdi"
        Picasso.get().load(url).into(t.imageYemek)

        t.imageViewArttir.setOnClickListener{



        }

        t.imageViewAzalt.setOnClickListener{


        }
    }

    override fun getItemCount(): Int {
        return sepetListesi.size
    }


}