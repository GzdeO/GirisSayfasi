package com.onecoder.girissayfasi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display.Mode
import android.view.View
import android.widget.Toast
import com.onecoder.girissayfasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        preferences=getSharedPreferences("bilgiler", MODE_PRIVATE)
        binding.btnGirisYap.setOnClickListener {
            var kayitliKullanici=preferences.getString("kullanici","")
            var kayitliParola=preferences.getString("parola","")

            var girilenKullanici=binding.girisKullaniciAdi.text.toString()
            var girilenParola=binding.girisParola.text.toString()

            if((kayitliKullanici==girilenKullanici) && (kayitliParola==girilenParola)){
                intent=Intent(applicationContext,MainHosgeldiniz::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(applicationContext,"Lütfen giriş bilgilerinizi kontrol ediniz !",Toast.LENGTH_LONG).show()
            }

        }
        binding.btnKayitOl.setOnClickListener {
            intent=Intent(applicationContext,MainKayitOl::class.java)
            startActivity(intent)
            finish()
        }


    }

}