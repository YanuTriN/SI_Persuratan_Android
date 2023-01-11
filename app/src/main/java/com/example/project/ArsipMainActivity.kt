package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ArsipMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.arsip_main)

        lateinit var text1: TextView

        text1 = findViewById(R.id.srt_masuk)
        text1.setOnClickListener {
            startActivity(Intent(this, ArsipMasukMainActivity::class.java))
        }

        lateinit var text2: TextView

        text2 = findViewById(R.id.srt_keluar)
        text2.setOnClickListener {
            startActivity(Intent(this, ArsipKeluarMainActivity::class.java))
        }
    }
}