package com.example.sumseltrip

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class JelajahActivity : BaseActivity() { // <-- Diubah menjadi turunan BaseActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_jelajah)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // ==========================================
        // 1. KELOLA KLIK KARTU KEBUN TEH -> DETAIL WISATA
        // ==========================================
        val cardKebunTeh = findViewById<CardView>(R.id.cardKebunTeh)
        cardKebunTeh?.setOnClickListener {
            val intent = Intent(this, DetailWisataActivity::class.java)
            startActivity(intent)
        }

        // ==========================================
        // 2. KELOLA KLIK PENCARIAN -> HASIL PENCARIAN
        // ==========================================
        val etPencarian = findViewById<EditText>(R.id.etPencarian)
        val btnIkonCari = findViewById<ImageView>(R.id.btnIkonCari)

        btnIkonCari?.setOnClickListener {
            val keyword = etPencarian?.text.toString()
            val intent = Intent(this, HasilPencarianActivity::class.java)
            intent.putExtra("EXTRA_KEYWORD", keyword)
            startActivity(intent)
        }

        // ==========================================
        // 3. NAVIGASI BAWAH OTOMATIS (CUKUP 1 BARIS!)
        // ==========================================
        setupGlobalNavigation(R.id.nav_jelajah)
    }
}