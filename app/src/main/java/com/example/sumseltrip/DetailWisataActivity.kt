package com.example.sumseltrip

import android.content.Intent
import android.net.Uri
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

        // 3. TOMBOL HUBUNGI WA - DEMPO HIGHLAND GLAMPING
        val btnHubungiGlamping = findViewById<Button>(R.id.btnHubungiGlamping)
        btnHubungiGlamping?.setOnClickListener {
            val phone = "083891501965" // Ganti dengan nomor WA Glamping
            val message = "Halo, saya ingin bertanya ketersediaan kamar di Dempo Highland Glamping."
            val url = "https://api.whatsapp.com/send?phone=$phone&text=${Uri.encode(message)}"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        // 4. TOMBOL HUBUNGI WA - VILLA RUMAH TERBUKA
        val btnHubungiVilla = findViewById<Button>(R.id.btnHubungiVilla)
        btnHubungiVilla?.setOnClickListener {
            val phone = "083891501965" // Ganti dengan nomor WA Villa
            val message = "Halo, saya ingin bertanya ketersediaan kamar di Villa Rumah Terbuka."
            val url = "https://api.whatsapp.com/send?phone=$phone&text=${Uri.encode(message)}"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}