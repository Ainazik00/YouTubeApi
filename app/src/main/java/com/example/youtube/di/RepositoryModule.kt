package com.example.youtube.di

import org.koin.dsl.module

val repositoryModule = module {

    single {
        YouTubeRepository(get())
    }
}