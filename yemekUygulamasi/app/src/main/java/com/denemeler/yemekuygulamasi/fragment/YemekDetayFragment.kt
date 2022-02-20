package com.denemeler.yemekuygulamasi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.denemeler.yemekuygulamasi.R
import com.denemeler.yemekuygulamasi.databinding.FragmentYemekDetayBinding
import com.denemeler.yemekuygulamasi.entity.Yemekler
import com.denemeler.yemekuygulamasi.viewmodel.YemekDetayViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.yemek_card_tasarim.*

class YemekDetayFragment : Fragment() {

    private lateinit var  tasarim: FragmentYemekDetayBinding
    private lateinit var viewModel:YemekDetayViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yemek_detay,container,false)

        tasarim.yemekDetayFragmentNesnesi = this

        val bundle: YemekDetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemek
        var yemekSiparisAdeti = 1
        var yeniYemekFiyati = 0
        

        tasarim.yemekNesnesi = gelenYemek
        var yemekAdi = gelenYemek.yemek_resim_adi
        var url = "http://kasimadalan.pe.hu/yemekler/resimler/$yemekAdi"
        Picasso.get().load(url).into(tasarim.imageViewYemek)


        tasarim.textViewSiparisSayi.text = "1"

        tasarim.imageViewAzalt.setOnClickListener{

            if(yemekSiparisAdeti>1 ){
                yemekSiparisAdeti = yemekSiparisAdeti-1
            }
            else if(yemekSiparisAdeti  == 0){yemekSiparisAdeti = 1}

            yeniYemekFiyati = gelenYemek.yemek_fiyat*yemekSiparisAdeti
            tasarim.textViewSiparisSayi.text = yemekSiparisAdeti.toString()
            tasarim.textViewYemekFiyat.text = "${yeniYemekFiyati.toString()} ₺"


        }

        tasarim.imageViewArttir.setOnClickListener{
            yemekSiparisAdeti = yemekSiparisAdeti+1
            yeniYemekFiyati = gelenYemek.yemek_fiyat*yemekSiparisAdeti
            tasarim.textViewSiparisSayi.text = yemekSiparisAdeti.toString()
            tasarim.textViewYemekFiyat.text = "${yeniYemekFiyati.toString()} ₺"

        }

        tasarim.buttonSepeteEkle.setOnClickListener{
            var yemeklerListesi  = ArrayList<Yemekler>()
            var sepetUrun = Yemekler(gelenYemek.yemek_id,gelenYemek.yemek_adi,gelenYemek.yemek_resim_adi, yemek_fiyat = yeniYemekFiyati)
            yemeklerListesi.add(sepetUrun)



        }






//        fun detayViewModel(){
//            viewModel.siparisSayi.observe(viewLifecycleOwner,{
//                tasarim.textViewSiparisSayi.text = it.toString()
//            })
//            viewModel.toplamTutar.observe(viewLifecycleOwner,{
//                tasarim.textViewYemekFiyat.text = it.toString()
//            })
//        }

//        fun buttonArttirTikla(adet:String, sayi:String){
//            viewModel.buttonArttirTikla(adet,sayi)
//        }
//
//        fun buttonAzaltTikla(adet:String, sayi:String){
//            viewModel.buttonAzaltTikla(adet,sayi)
//        }

        fun buttonSepeteEkleTikla(){
//                viewModel.(tasarim.yemekNesnesi!!.yemek_adi,tasarim.yemekNesnesi!!.yemek_resim_adi,
//                    tasarim.textViewYemekFiyat.text.toString().toInt(),
//                tasarim.textViewSiparisSayi.text.toString().toInt(),
//                    kullanici_adi = "merve")
        }


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : YemekDetayViewModel by viewModels()
        viewModel = tempViewModel
    }




}