package com.example.buffyvirtualpet

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainButton = findViewById<Button>(R.id.welcomeButton)

        //Starting the main screen once the button is clicked
        mainButton.setOnClickListener {
            val intent = Intent(this, mainPetScreen::class.java)
            startActivity(intent)}

    }
}