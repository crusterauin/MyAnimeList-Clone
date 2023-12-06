package com.example.submisi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submisi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvAnime: RecyclerView
    private val list = ArrayList<Anime>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        rvAnime = binding.rvAnime
        rvAnime.setHasFixedSize(true)

        list.addAll(listAnime)
        showRecyclerList()

        binding.about.setOnClickListener() {
            onImageButtonClick(it)

        }
    }

    private val listAnime: ArrayList<Anime>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.getStringArray(R.array.data_photo)
            val dataRating = resources.getStringArray(R.array.rating)
            val dataStudio = resources.getStringArray(R.array.studio)
            val dataEpisode = resources.getStringArray(R.array.episode)
            val dataAired = resources.getStringArray(R.array.aired)
            val dataLinkMAL = resources.getStringArray(R.array.linkMAL)
            val dataLinkYT = resources.getStringArray(R.array.linkYT)
            val listHero = ArrayList<Anime>()
            for (i in dataName.indices) {
                val anime = Anime(dataName[i], dataDescription[i], dataPhoto[i], dataStudio[i], dataEpisode[i], dataAired[i], dataRating[i], dataLinkMAL[i], dataLinkYT[i])
                listHero.add(anime)
            }
            return listHero
        }

    private fun showRecyclerList() {
        rvAnime.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListAnimeAdapter(list)
        rvAnime.adapter = listHeroAdapter
    }

    private fun onImageButtonClick(view: android.view.View) {
        val intent = Intent(this, About::class.java)
        startActivity(intent)
    }
}