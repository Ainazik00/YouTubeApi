package com.example.youtube.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import com.bumptech.glide.load.engine.Resource
import com.example.youtube.data.base.BaseActivity
import com.example.youtube.data.model.BaseResponse
import com.example.youtube.databinding.ActivityMainBinding
import com.example.youtube.ui.main.adapter.MainAdapter
import com.example.youtube.ui.playlists.PlaylistActivity

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private val  viewModel:MainViewModel by viewModel()
    private lateinit var adapter: MainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getPlaylists().stateHandler(
            success = {
                adapter = MainAdapter(this::onClick)
                adapter.submitList(it)
                binding.recyclerView.adapter = adapter
            },
            state = {
                binding.progressBar.isVisible = it is Resource.Loading
            }
        )
    }


    private fun onClick(item: BaseResponse.Item) {
        val intent = Intent(this, PlaylistActivity::class.java)
        intent.putExtra("id", item.id)
        intent.putExtra("size", item.contentDetails.itemCount)
        intent.putExtra("title", item.snippet.title)
        intent.putExtra("description", item.snippet.description)
        startActivity(intent)
    }
}