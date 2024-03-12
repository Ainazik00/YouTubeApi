package com.example.youtube.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import com.example.youtube.data.model.BaseResponse
import com.example.youtube.data.repository.YouTubeRepository

class MainViewModel (private val repository: YouTubeRepository): ViewModel() {

    fun getPlaylists(): LiveData<Resource<List<BaseResponse.Item>>> = repository.getPlaylists()

}