package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityVideoBinding
import com.example.myapplication.youtube.Playlist

@Suppress("DEPRECATION")
class VideoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityVideoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)

        val playlist = intent.getSerializableExtra("playlist") as Playlist

        binding.apply {
            playlistTitle.text = playlist.title
            playlistDescription.text = playlist.description

            recyclerView.apply {
                layoutManager = LinearLayoutManager(this@VideoActivity)
                adapter = VideoAdapter {
                }
            }
        }
    }
}
