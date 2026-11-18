package com.example.sumseltrip

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetailWisataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_wisata)

        // 1. TOMBOL KEMBALI
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack?.setOnClickListener {
            finish() // Kembali ke halaman JelajahActivity
        }

        // 2. TOMBOL LIHAT TINGKAT KERAMALAN
        val btnKeramalan = findViewById<Button>(R.id.btnKeramalan)
        btnKeramalan?.setOnClickListener {
            val intent = Intent(this, TingkatKeramaianActivity::class.java)
            startActivity(intent)
        }
    }
}