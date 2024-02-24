package com.example.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.PlaylistItemBinding
import com.example.myapplication.youtube.Playlist

class PlaylistAdapter(private val onClick: (Playlist) -> Unit) :
    ListAdapter<Playlist, PlaylistAdapter.PlaylistViewHolder>(PlaylistDiffCallback()) {

    class PlaylistViewHolder(val binding: PlaylistItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val binding = PlaylistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaylistViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val playlist = getItem(position)
        with(holder.binding) {
            playlistTitle.text = playlist.title
            playlistVideoCount.text = "${playlist.videoCount} video series"
            root.setOnClickListener { onClick(playlist) }
        }
    }

    class PlaylistDiffCallback : DiffUtil.ItemCallback<Playlist>() {
        override fun areItemsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
            return oldItem == newItem
        }
    }
}
