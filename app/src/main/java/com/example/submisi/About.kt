package com.example.submisi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.submisi.databinding.AboutBinding

class About : AppCompatActivity() {

    private lateinit var binding: AboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.include.textView.text = getString(R.string.about)

        binding.include.imageButton.setOnClickListener() {
            finish()
        }
    }
}