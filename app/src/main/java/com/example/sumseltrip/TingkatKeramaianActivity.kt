package com.example.sumseltrip

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class TingkatKeramaianActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tingkat_keramaian)

        // Tombol Kembali
        val btnBack = findViewById<ImageView>(R.id.btnBackKeramaian)
        if (btnBack != null) {
            btnBack.setOnClickListener {
                finish()
            }
        }
    }
}