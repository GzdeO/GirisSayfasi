package com.onecoder.girissayfasi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.onecoder.girissayfasi.databinding.ActivityMainKayitOlBinding

class MainKayitOl : AppCompatActivity() {
    lateinit var binding: ActivityMainKayitOlBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainKayitOlBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)


        binding.btnKaydet.setOnClickListener {
            var SharedPreferences=this.getSharedPreferences("bilgiler", MODE_PRIVATE)

            var girilenKullanici=binding.kayitKullaniciAdi.text.toString()
            var girilenParola=binding.kayitParola.text.toString()

            var editor=SharedPreferences.edit()
            editor.putString("kullanici","$girilenKullanici").apply()
            editor.putString("parola","$girilenParola").apply()

            Toast.makeText(applicationContext,"Kayıt Başarılı",Toast.LENGTH_LONG).show()

        }
        binding.btnGiriseDon.setOnClickListener {
            intent=Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }

    }
}