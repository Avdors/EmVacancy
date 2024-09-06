package com.example.mainlist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.usecase.GetOffersAndVacanciesUseCase
import com.example.mainlist.domain.model.OfferMainFragmentModel
import com.example.mainlist.domain.model.VacancyMainFragmentModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainListViewModel(
    private val getOffersAndVacanciesUseCase: GetOffersAndVacanciesUseCase
): ViewModel() {

    // StateFlow для хранения состояния списка OfferFeatureModel
    private val _offers = MutableStateFlow<List<OfferMainFragmentModel>>(emptyList())
    val offers: StateFlow<List<OfferMainFragmentModel>> = _offers.asStateFlow()

    // StateFlow для хранения состояния списка VacancyFeatureModel
    private val _vacancies = MutableStateFlow<List<VacancyMainFragmentModel>>(emptyList())
    val vacancies: StateFlow<List<VacancyMainFragmentModel>> = _vacancies.asStateFlow()

    // Функция для загрузки данных
    fun loadData() {
        viewModelScope.launch(Dispatchers.Default) {
            val (offerModels, vacancyModels) = getOffersAndVacanciesUseCase.execute()
            _offers.value = offerModels.map { it.toFeatureModel() }  // Обновляем список offers
            _vacancies.value = vacancyModels.map { it.toFeatureModel() }  // Обновляем список vacancies
        }
    }
}