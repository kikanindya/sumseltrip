package com.example.sumseltrip

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HasilPencarianActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hasil_pencarian)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bottomNavigation)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. TOMBOL KEMBALI (BACK)
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack?.setOnClickListener {
            finish() // Kembali ke halaman sebelumnya
        }

        // 2. NAVIGASI BAWAH (BOTTOM NAVIGATION)
        findViewById<LinearLayout>(R.id.bottomNavigation).getChildAt(0).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            overridePendingTransition(0, 0)
            finish()
        }

        findViewById<LinearLayout>(R.id.bottomNavigation).getChildAt(1).setOnClickListener {
            startActivity(Intent(this, JelajahActivity::class.java))
            overridePendingTransition(0, 0)
            finish()
        }

        findViewById<LinearLayout>(R.id.bottomNavigation).getChildAt(2).setOnClickListener {
            // Pemandu
        }

        findViewById<LinearLayout>(R.id.bottomNavigation).getChildAt(3).setOnClickListener {
            startActivity(Intent(this, FavoritActivity::class.java))
            overridePendingTransition(0, 0)
            finish()
        }

        findViewById<LinearLayout>(R.id.bottomNavigation).getChildAt(4).setOnClickListener {
            startActivity(Intent(this, ProfilActivity::class.java))
            overridePendingTransition(0, 0)
            finish()
        }
    }
}