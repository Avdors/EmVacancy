package com.example.mainlist.di

import com.example.mainlist.presentation.MainListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainListModule = module {
    viewModel { MainListViewModel(get()) } // Инжектируем UseCase из core
}