package com.example.core.data.repository

import com.example.core.data.network.NetworkServiceImpl
import com.example.core.data.storage.DataLocalStorage
import com.example.core.domain.model.Offer
import com.example.core.domain.model.ResponseData
import com.example.core.domain.model.Vacancy
import com.example.core.domain.repository.ApiResponseRepository
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class DataSaveRepositoryImpl(
    private val networkService: NetworkServiceImpl,
    private val datalocalStorage: DataLocalStorage

): ApiResponseRepository {
    override suspend fun getData(): List<ResponseData> {
        // Получаем данные из сети
        val response = networkService.getData()

        // Преобразуем response в списки
        return response
    }

    override suspend fun saveData(data: Any) {
        // Пример сохранения данных в локальное хранилище
        if (data is ResponseData) {
            val jsonData = Json.encodeToString(data)
            datalocalStorage.saveData(jsonData)
        }
    }

    fun mapResponseToOffersAndVacancies(response: ResponseData): Pair<List<Offer>, List<Vacancy>> {
        val offers = response.offers.orEmpty().filterNotNull()
        val vacancies = response.vacancies.orEmpty().filterNotNull()
        return offers to vacancies
    }

}