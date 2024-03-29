package com.example.youtube.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        PlaylistsViewModel(get())
    }

    viewModel {
        VideoViewModel(get())
    }
}