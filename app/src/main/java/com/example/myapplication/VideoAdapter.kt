package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.VideoItemBinding
import com.example.myapplication.youtube.Video

class VideoAdapter(private val onClick: (Video) -> Unit) :
    ListAdapter<Video, VideoAdapter.VideoViewHolder>(VideoDiffCallback()) {

    class VideoViewHolder(val binding: VideoItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = VideoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = getItem(position)
        with(holder.binding) {
            videoTitle.text = video.title
            videoDuration.text = video.duration
            root.setOnClickListener { onClick(video) }
        }
    }

    class VideoDiffCallback : DiffUtil.ItemCallback<Video>() {
        override fun areItemsTheSame(oldItem: Video, newItem: Video): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean {
            return oldItem == newItem
        }
    }
}
