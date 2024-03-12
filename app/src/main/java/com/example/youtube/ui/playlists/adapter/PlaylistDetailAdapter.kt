package com.example.youtube.ui.playlists.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtube.data.model.VideoModel
import com.example.youtube.databinding.ItemDetailBinding

class PlaylistDetailAdapter :
    ListAdapter<VideoModel.Item, PlaylistsVideoViewHolder>(PlaylistVideoDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistsVideoViewHolder {
        return PlaylistsVideoViewHolder(
            ItemDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistsVideoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class PlaylistsVideoViewHolder(private val binding: ItemDetailBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(model: VideoModel.Item) = with(binding) {
        tvTitle.text = model.snippet.title
        Glide.with(image).load(model.snippet.thumbnails.default.url).into(image)
    }
}

class PlaylistVideoDiffCallback : DiffUtil.ItemCallback<VideoModel.Item>() {
    override fun areItemsTheSame(oldItem: VideoModel.Item, newItem: VideoModel.Item) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: VideoModel.Item, newItem: VideoModel.Item) =
        oldItem == newItem

}