package com.example.sumseltrip

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class JelajahActivity : AppCompatActivity() {
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
        // 3. NAVIGASI BAWAH (BOTTOM NAVIGATION)
        // ==========================================
        // Tombol Beranda
        findViewById<LinearLayout>(R.id.bottomNavigation).getChildAt(0).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            overridePendingTransition(0, 0)
            finish()
        }

        // Tombol Jelajah
        findViewById<LinearLayout>(R.id.bottomNavigation).getChildAt(1).setOnClickListener {
            // Sedang di halaman jelajah
        }

        // Tombol Pemandu
        findViewById<LinearLayout>(R.id.bottomNavigation).getChildAt(2).setOnClickListener {
            // Pemandu
        }

        // Tombol Favorit
        findViewById<LinearLayout>(R.id.bottomNavigation).getChildAt(3).setOnClickListener {
            startActivity(Intent(this, FavoritActivity::class.java))
            overridePendingTransition(0, 0)
            finish()
        }

        // Tombol Profil
        findViewById<LinearLayout>(R.id.bottomNavigation).getChildAt(4).setOnClickListener {
            startActivity(Intent(this, ProfilActivity::class.java))
            overridePendingTransition(0, 0)
            finish()
        }
    }
}