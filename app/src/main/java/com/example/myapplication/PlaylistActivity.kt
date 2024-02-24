package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityPlaylistBinding
import com.example.myapplication.youtube.Playlist

class PlaylistActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityPlaylistBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@PlaylistActivity)
            adapter = PlaylistAdapter { playlist ->
                onPlaylistSelected(playlist)
            }
        }
    }

    private fun onPlaylistSelected(playlist: Playlist) {
        val intent = Intent(this, VideoActivity::class.java)
        intent.putExtra("playlist", playlist)
        startActivity(intent)
    }
}
