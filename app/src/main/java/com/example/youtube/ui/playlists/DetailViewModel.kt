package com.example.youtube.ui.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import com.example.youtube.data.model.VideoModel
import com.example.youtube.data.repository.YouTubeRepository

class DetailViewModel(private val repository: YouTubeRepository) : ViewModel() {

    fun getPlaylistVideo(getId: String, listSize:Int): LiveData<Resource<List<VideoModel.Item>>> =
        repository.getPlaylistVideo(getId, listSize)

}