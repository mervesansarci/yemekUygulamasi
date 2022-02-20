package com.denemeler.yemekuygulamasi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.denemeler.yemekuygulamasi.R
import com.denemeler.yemekuygulamasi.databinding.YemekCardTasarimBinding
import com.denemeler.yemekuygulamasi.entity.Yemekler
import com.denemeler.yemekuygulamasi.fragment.AnasayfaFragmentDirections
import com.denemeler.yemekuygulamasi.viewmodel.AnasayfaFragmentViewModel
import com.squareup.picasso.Picasso

class YemeklerAdapter(var mContext:Context,
                      var yemekListesi:List<Yemekler>,
                      var viewModel:AnasayfaFragmentViewModel
                      )
    : RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(cardTasarimBinding: YemekCardTasarimBinding) :
        RecyclerView.ViewHolder(cardTasarimBinding.root) {

        var cardTasarimBinding: YemekCardTasarimBinding

        init {

            this.cardTasarimBinding = cardTasarimBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {

        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = YemekCardTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = yemekListesi.get(position)
        val t = holder.cardTasarimBinding
        t.yemekNesnesi = yemek
        val yemekAdi = yemek.yemek_resim_adi
        var url = "http://kasimadalan.pe.hu/yemekler/resimler/$yemekAdi"
        Picasso.get().load(url).into(t.imageYemek)


        t.yemekCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.anasayfaToYemekDetay(yemek)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return yemekListesi.size
    }

}





