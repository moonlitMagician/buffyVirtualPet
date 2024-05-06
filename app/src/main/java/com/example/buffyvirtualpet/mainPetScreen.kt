package com.example.buffyvirtualpet

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//for the rest of the project, the object representing everything to do with the main pet
//(including, the needs, images and overall state of the object)
//will be referred to as buffy

class mainPetScreen : AppCompatActivity() {

    //each value declared globally be used in other functions
    var cleanValue = 100
    var happyValue = 100
    var hungerValue = 100
    var idleTimer = 3

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_pet_screen)

        val cleanButton = findViewById<Button>(R.id.cleanButton)
        val feedButton = findViewById<Button>(R.id.feedButton)
        val playButton = findViewById<Button>(R.id.playButton)
        val failText = findViewById<TextView>(R.id.failText)
        val buffyImage = findViewById<ImageView>(R.id.buffyImageMain)

        val cleanliness = findViewById<ProgressBar>(R.id.cleanBar)
        val happiness = findViewById<ProgressBar>(R.id.playBar)
        val hunger = findViewById<ProgressBar>(R.id.hungerBar)
        val intent = Intent(this, failScreen::class.java)



        GlobalScope.launch {

            //increase the cleanliness stat once the "clean button" is pressed
            //and changing the image to the relevant one

            cleanButton.setOnClickListener {
                cleanBuffy(cleanliness)
                buffyImage.setImageResource(R.drawable.buffybath)
                idleTimer = 0
            }

            //increase the hunger stat once the "feed" button is clicked
            //and changing the image to the relevant one

            feedButton.setOnClickListener {
                feedBuffy(hunger)
                buffyImage.setImageResource(R.drawable.buffyeat)
                idleTimer = 0
            }

            //increase the happiness stat once the "play" button is clicked
            //and changing the image to the relevant

            playButton.setOnClickListener {
                playBuffy(happiness)
                buffyImage.setImageResource(R.drawable.buffyplay)
                idleTimer = 0
            }

            //the while loop consistently ticks down each need, so the user has to constantly adjust
            //buffy's needs by using each button

            //the "idle timer" tracks whether or not the user has clicked a button recently
            //if not, the image returns to the default image for Buffy

            while (cleanValue >= 0 && happyValue >= 0 && hungerValue >= 0) {

                while (idleTimer < 3){
                    idleTimer += 1
                }

                if(idleTimer <= 3){
                    buffyImage.setImageResource(R.drawable.buffyone)
                }

                decreaseClean(cleanliness)
                decreaseHunger(hunger)
                decreaseHappiness(happiness)

                if (cleanValue < 0 || happyValue < 0 || hungerValue < 0) {
                    startActivity(intent)
                }
            }
        }


    }

    //decreases the cleanliness stat by 3 every 2 seconds
    fun decreaseClean(cleanBar: ProgressBar){
        cleanBar.incrementProgressBy(-3)
        cleanValue -= 3
        Thread.sleep(2000)
    }

    //decreases the hunger stat by 5 every 2 seconds
    fun decreaseHunger(hungerBar: ProgressBar){
        hungerBar.incrementProgressBy(-5)
        hungerValue -= 5
        Thread.sleep(2000)
    }

    //decreases the happiness stat by 6 every 2 seconds
    fun decreaseHappiness(happyBar: ProgressBar){
        happyBar.incrementProgressBy(-6)
        happyValue -= 6
        Thread.sleep(2000)
    }

    //dictates how much cleanliness is increased by when the button is pressed
    fun cleanBuffy(cleanBar: ProgressBar){
        cleanBar.incrementProgressBy(6)
        cleanValue += 6

    }

    //dictates how much hunger is increased by when the button is pressed
    fun feedBuffy(hungerBar: ProgressBar){
        hungerBar.incrementProgressBy(10)
        hungerValue += 10
    }

    //dictates how much happiness is increased by when the button is pressed
    fun playBuffy(playBar: ProgressBar){
        playBar.incrementProgressBy(12)
        happyValue += 12
    }

}