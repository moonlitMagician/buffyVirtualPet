package com.example.buffyvirtualpet

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class failScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fail_screen)
        val restartButton = findViewById<Button>(R.id.retryButton)
        //sends the user back to the main screen once the "try again" button is clicked
        val intent = Intent(this, mainPetScreen::class.java)
        restartButton.setOnClickListener {
            startActivity(intent)
        }

    }
}