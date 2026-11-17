package com.example.sumseltrip

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

        // Menghubungkan setiap tombol menu bawah agar bisa diklik untuk pindah halaman

        // 1. Tombol Beranda
        findViewById<LinearLayout>(R.id.bottomNavigation).getChildAt(0).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            overridePendingTransition(0, 0)
            finish()
        }

        // 2. Tombol Jelajah (karena sedang di halaman Jelajah, dibiarkan diam atau aktif)
        findViewById<LinearLayout>(R.id.bottomNavigation).getChildAt(1).setOnClickListener {
            // Sedang di halaman jelajah
        }

        // 3. Tombol Pemandu (jika ada activity-nya, bisa diarahkan ke sini)
        findViewById<LinearLayout>(R.id.bottomNavigation).getChildAt(2).setOnClickListener {
            // Tambahkan Intent PemanduActivity jika sudah dibuat
        }

        // 4. Tombol Favorit
        findViewById<LinearLayout>(R.id.bottomNavigation).getChildAt(3).setOnClickListener {
            startActivity(Intent(this, FavoritActivity::class.java))
            overridePendingTransition(0, 0)
            finish()
        }

        // 5. Tombol Profil
        findViewById<LinearLayout>(R.id.bottomNavigation).getChildAt(4).setOnClickListener {
            startActivity(Intent(this, ProfilActivity::class.java))
            overridePendingTransition(0, 0)
            finish()
        }
    }
}