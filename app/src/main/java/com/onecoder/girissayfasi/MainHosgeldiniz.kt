package com.onecoder.girissayfasi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.onecoder.girissayfasi.databinding.ActivityMainBinding
import com.onecoder.girissayfasi.databinding.ActivityMainHosgeldinizBinding

class MainHosgeldiniz : AppCompatActivity() {

    lateinit var binding: ActivityMainHosgeldinizBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainHosgeldinizBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        preferences=getSharedPreferences("bilgiler", MODE_PRIVATE)

        var kayitliKullanici=preferences.getString("kullanici","")
        var kayitliParola=preferences.getString("parola","")

        binding.kullaniciBilgisi.text="Kullanıcı Adı: $kayitliKullanici".toString()
        binding.kullaniciParola.text="Parola: $kayitliParola".toString()
        binding.btnCikisYap.setOnClickListener {
            intent=Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}