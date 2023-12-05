package com.example.submisi

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.submisi.databinding.DetailAnimeBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: DetailAnimeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DetailAnimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.include.textView.text = getString(R.string.detail)

        val dataAnime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            intent.getParcelableExtra<Anime>("key_anime")
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Anime>("key_anime")
        }

        binding.judulAnime.text = dataAnime?.name
        binding.deskripsiAnime.text = dataAnime?.description
        binding.studio.text = dataAnime?.studio
        binding.episode.text = dataAnime?.episode
        binding.aired.text = dataAnime?.aired
        binding.rating.text = dataAnime?.rating

        Glide.with(this)
            .load(dataAnime?.photo)
            .into(binding.posterAnime)

        val share = Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, "");
        startActivity(Intent.createChooser(share, "Share Link"));

        binding.include.imageButton.setOnClickListener {
            finish()
        }
    }
}