package com.example.core.di

import com.example.core.data.network.NetworkServiceImpl
import com.example.core.data.repository.DataSaveRepositoryImpl
import com.example.core.domain.repository.ApiResponseRepository
import com.example.core.domain.usecase.DataMapper
import com.example.core.domain.usecase.GetOffersAndVacanciesUseCase
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module

val coreModule = module {

    // Регистрация HttpClient
    single {
        HttpClient(Android){
            install(ContentNegotiation){
                json()
            }
            install(Logging){
                level = LogLevel.ALL
            }
        }
    }
    factory { GetOffersAndVacanciesUseCase(get(), get()) } // UseCase для получения данных
    factory { DataMapper() }  // DataMapper для преобразования данных
    single<ApiResponseRepository> { DataSaveRepositoryImpl(get(), get()) } // Репозиторий
    single { NetworkServiceImpl(get()) } // Сервис для работы с сетью
}