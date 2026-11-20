package com.example.sumseltrip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

open class BaseActivity : AppCompatActivity() {

    protected fun setupGlobalNavigation(activeMenuId: Int) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        // Pastikan menu yang aktif sesuai dengan halaman saat ini
        bottomNav?.menu?.findItem(activeMenuId)?.isChecked = true

        // Listener menu bawah
        bottomNav?.setOnItemSelectedListener { item ->
            // Jika menu yang dipencet adalah halaman yang sedang aktif, abaikan
            if (item.itemId == activeMenuId) return@setOnItemSelectedListener true

            // Tentukan tujuan halaman berdasarkan item yang dipencet
            val intent = when (item.itemId) {
                R.id.nav_home -> Intent(this, HomeActivity::class.java)
                R.id.nav_jelajah -> Intent(this, JelajahActivity::class.java)
                R.id.nav_pemandu -> Intent(this, PemanduActivity::class.java)
                R.id.nav_favorit -> Intent(this, FavoritActivity::class.java)
                R.id.nav_profil -> Intent(this, ProfilActivity::class.java)
                else -> null
            }

            // Jalankan perpindahan halaman jika intent tidak null
            intent?.let {
                startActivity(it)
                overridePendingTransition(0, 0)
                finish()
            }
            true
        }
    }
}