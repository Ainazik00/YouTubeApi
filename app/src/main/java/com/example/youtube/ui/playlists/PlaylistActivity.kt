package com.example.youtube.ui.playlists

import android.os.Bundle
import com.bumptech.glide.load.engine.Resource
import com.example.youtube.data.base.BaseActivity
import com.example.youtube.databinding.ActivityPlaylistBinding
import com.example.youtube.ui.playlists.adapter.PlaylistDetailAdapter

class PlaylistActivity : BaseActivity() {
    private lateinit var binding: ActivityPlaylistBinding
    private val viewModel: DetailViewModel by viewModel()
    private val adapter by lazy {
        PlaylistDetailAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaylistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvPlaylistItems.adapter = adapter

        val getId = intent.getStringExtra("id").toString()
        val getTitle = intent.getStringExtra("title").toString()
        val getDesc = intent.getStringExtra("description").toString()
        val getSize = intent.getIntExtra("size", 0)

        binding.tvTitle.text = getTitle
        binding.tvDescription.text = getDesc

        viewModel.getPlaylistVideo(getId, getSize).stateHandler(
            success = {
                adapter.submitList(it)
            },
            state = { binding.progressBar.isVisible = it is Resource.Loading }
        )
    }
}