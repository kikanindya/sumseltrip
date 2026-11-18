package com.example.sumseltrip

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

open class BaseActivity : AppCompatActivity() {

    protected fun setupGlobalNavigation(activeMenuId: Int) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        // Tandai menu samping mana yang aktif
        if (activeMenuId != R.id.nav_pemandu) {
            bottomNav?.menu?.findItem(activeMenuId)?.isChecked = true
        }

        // Kustomisasi item tengah (Pemandu) secara otomatis agar selalu kuning dan menonjol
        bottomNav?.menu?.findItem(R.id.nav_pemandu)?.let { pemanduItem ->
            pemanduItem.title = "Pemandu"
            pemanduItem.setIcon(R.drawable.ic_nav_profil) // Sesuaikan ikon pemandu kamu
            pemanduItem.isEnabled = true
        }

        // Berikan warna khusus kuning untuk ikon/teks Pemandu jika ingin dibedakan
        val states = arrayOf(
            intArrayOf(android.R.attr.state_checked),
            intArrayOf(-android.R.attr.state_checked)
        )
        val colors = intArrayOf(
            Color.parseColor("#EAB308"), // Kuning aktif
            Color.parseColor("#EAB308")  // Kuning permanen untuk pemandu
        )
        // Jika butuh pewarnaan kustom per item bisa disesuaikan,
        // tapi biarkan bottomNavigationView menghandle sisanya.

        // Listener Navigasi Bawah
        bottomNav?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    if (activeMenuId != R.id.nav_home) {
                        startActivity(Intent(this, HomeActivity::class.java))
                        overridePendingTransition(0, 0)
                        finish()
                    }
                    true
                }
                R.id.nav_jelajah -> {
                    if (activeMenuId != R.id.nav_jelajah) {
                        startActivity(Intent(this, JelajahActivity::class.java))
                        overridePendingTransition(0, 0)
                        finish()
                    }
                    true
                }
                R.id.nav_pemandu -> {
                    if (activeMenuId != R.id.nav_pemandu) {
                        startActivity(Intent(this, PemanduActivity::class.java))
                        overridePendingTransition(0, 0)
                        finish()
                    }
                    true
                }
                R.id.nav_favorit -> {
                    if (activeMenuId != R.id.nav_favorit) {
                        startActivity(Intent(this, FavoritActivity::class.java))
                        overridePendingTransition(0, 0)
                        finish()
                    }
                    true
                }
                R.id.nav_profil -> {
                    if (activeMenuId != R.id.nav_profil) {
                        startActivity(Intent(this, ProfilActivity::class.java))
                        overridePendingTransition(0, 0)
                        finish()
                    }
                    true
                }
                else -> false
            }
        }
    }
}