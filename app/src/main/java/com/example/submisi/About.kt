package com.example.submisi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.submisi.databinding.AboutBinding


class About : AppCompatActivity() {

    private lateinit var binding: AboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.include.textView.text = getString(R.string.about)

        val instagram = Intent(Intent.ACTION_VIEW,
            Uri.parse("https://www.instagram.com/fatur.fz/"))
        val github = Intent(Intent.ACTION_VIEW,
            Uri.parse("https://github.com/crusterauin"))
        val discord = Intent(Intent.ACTION_VIEW,
            Uri.parse("https://discordapp.com/users/427360592106618881"))


        val btnIntentInstagram: ImageButton = binding.instagram
        val btnIntentGithub: ImageButton = binding.github
        val btnIntentDiscord: ImageButton = binding.discord

        btnIntentInstagram.setOnClickListener{
            startActivity(instagram)
        }
        btnIntentGithub.setOnClickListener{
            startActivity(github)
        }
        btnIntentDiscord.setOnClickListener{
            startActivity(discord)
        }

        binding.include.imageButton.setOnClickListener {
            finish()
        }
    }
}