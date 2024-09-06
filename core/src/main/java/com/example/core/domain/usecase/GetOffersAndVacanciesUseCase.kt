package com.example.core.domain.usecase

import com.example.core.domain.model.OfferCoreModel
import com.example.core.domain.model.VacancyCoreModel
import com.example.core.domain.repository.ApiResponseRepository

class GetOffersAndVacanciesUseCase(
    private val repository: ApiResponseRepository, // Получаем данные из репозитория
    private val dataMapper: DataMapper // Маппим данные в нужные модели
) {
    suspend fun execute(): Pair<List<OfferCoreModel>, List<VacancyCoreModel>> {
        val responseDataList = repository.getData() // Загружаем список данных из репозитория

        // Преобразуем каждый элемент списка ResponseData и объединяем результаты
        var allOffers = mutableListOf<OfferCoreModel>()
        var allVacancies = mutableListOf<VacancyCoreModel>()

        responseDataList.forEach { responseData ->
            val (offers, vacancies) = dataMapper.mapResponseToOffersAndVacancies(responseData)
            allOffers.addAll(offers)
            allVacancies.addAll(vacancies)
        }

        return allOffers to allVacancies
    }
}