package com.example.submisi

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.ImageButton
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

        val listAnime = intent.getParcelableArrayListExtra<Anime>("key_anime_list")

        val dataAnime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            intent.getParcelableExtra<Anime>("key_anime")
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Anime>("key_anime")
        }

        val position = listAnime?.indexOfFirst { it == dataAnime }

        binding.judulAnime.text = dataAnime?.name
        binding.deskripsiAnime.text = dataAnime?.description
        binding.studio.text = dataAnime?.studio
        binding.episode.text = dataAnime?.episode
        binding.aired.text = dataAnime?.aired
        binding.rating.text = dataAnime?.rating

        Glide.with(this)
            .load(dataAnime?.photo)
            .into(binding.posterAnime)

        val linkMALArray = resources.getStringArray(R.array.linkMAL)
        val linkMAL = position?.let { linkMALArray.getOrNull(it) }

        val linkYTArray = resources.getStringArray(R.array.linkYT)
        val linkYT = position?.let {linkYTArray.getOrNull(it)}

        val share = Intent(Intent.ACTION_SEND);
        share.type = "text/plain";
        val shareMessage = "Check out this anime:\n$linkMAL"
        share.putExtra(Intent.EXTRA_TEXT, shareMessage);

        val playPV = Intent(Intent.ACTION_VIEW,);
        linkYT?.let {
            playPV.data = Uri.parse(it)
        }

        val openMAL = Intent(Intent.ACTION_VIEW);
        linkMAL?.let {
            openMAL.data = Uri.parse(it)
        }

        val btnIntentShare: ImageButton = binding.share
        btnIntentShare.setOnClickListener{
            startActivity(Intent.createChooser(share, "Share Link"))
        }

        val btnIntentPlayPV: ImageButton = binding.playPV
        btnIntentPlayPV.setOnClickListener{
            startActivity(playPV)
        }

        val btnIntentOpenMAL: ImageButton = binding.openMAL
        btnIntentOpenMAL.setOnClickListener{
            startActivity(openMAL)
        }

        binding.include.imageButton.setOnClickListener {
            finish()
        }
    }
}