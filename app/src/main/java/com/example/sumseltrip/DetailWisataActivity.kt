package com.example.sumseltrip

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailWisataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_wisata)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // 1. TOMBOL KEMBALI (Jika di layout detail ada tombol kembali, misal id-nya btnBack)
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack?.setOnClickListener {
            finish() // Kembali ke halaman sebelumnya (JelajahActivity)
        }

        // 2. NAVIGASI BAWAH (BOTTOM NAVIGATION) - Jika ada di halaman detail
        val bottomNav = findViewById<LinearLayout>(R.id.bottomNavigation)
        if (bottomNav != null) {
            bottomNav.getChildAt(0).setOnClickListener {
                startActivity(Intent(this, HomeActivity::class.java))
                overridePendingTransition(0, 0)
                finish()
            }

            bottomNav.getChildAt(1).setOnClickListener {
                startActivity(Intent(this, JelajahActivity::class.java))
                overridePendingTransition(0, 0)
                finish()
            }

            bottomNav.getChildAt(2).setOnClickListener {
                // Pemandu
            }

            bottomNav.getChildAt(3).setOnClickListener {
                startActivity(Intent(this, FavoritActivity::class.java))
                overridePendingTransition(0, 0)
                finish()
            }

            bottomNav.getChildAt(4).setOnClickListener {
                startActivity(Intent(this, ProfilActivity::class.java))
                overridePendingTransition(0, 0)
                finish()
            }
        }
    }
}