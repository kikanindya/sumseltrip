package com.example.sumseltrip

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PemanduActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pemandu)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // Tombol Kembali
        findViewById<ImageView>(R.id.btnBackPemandu)?.setOnClickListener {
            finish()
        }

        // Hubungkan setiap tombol "Hubungi" ke WhatsApp
        hubungkanWhatsApp(
            buttonId = R.id.btnHubungiTransNusa,
            nomorWa = "083891501965",
            pesan = "Halo CV Trans Antar Nusa, saya ingin menanyakan paket tour guide di Sumatera Selatan."
        )

        hubungkanWhatsApp(
            buttonId = R.id.btnHubungiPutraWijaya,
            nomorWa = "083891501965",
            pesan = "Halo Putra Wijaya, saya ingin menanyakan layanan tour guide fotografi & kuliner."
        )

        hubungkanWhatsApp(
            buttonId = R.id.btnHubungiKenziTour,
            nomorWa = "083891501965",
            pesan = "Halo Kenzi Tour Palembang, saya ingin menanyakan layanan tour guide & VIP transport."
        )

        // Navigasi Bawah Global
        setupGlobalNavigation(R.id.nav_pemandu)
    }

    private fun hubungkanWhatsApp(buttonId: Int, nomorWa: String, pesan: String) {
        findViewById<Button>(buttonId)?.setOnClickListener {
            val nomorBersih = nomorWa.replace(Regex("[^0-9]"), "")
            val url = "https://api.whatsapp.com/send?phone=$nomorBersih&text=${Uri.encode(pesan)}"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

            try {
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "WhatsApp tidak dapat dibuka di perangkat ini", Toast.LENGTH_SHORT).show()
            }
        }
    }
}