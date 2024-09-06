package com.example.core.domain.usecase

import com.example.core.domain.model.Address
import com.example.core.domain.model.AddressFeatureModel
import com.example.core.domain.model.Button
import com.example.core.domain.model.ButtonFeatureModel
import com.example.core.domain.model.Experience
import com.example.core.domain.model.ExperienceFeatureModel
import com.example.core.domain.model.Offer
import com.example.core.domain.model.OfferFeatureModel
import com.example.core.domain.model.ResponseData
import com.example.core.domain.model.Salary
import com.example.core.domain.model.SalaryFeatureModel
import com.example.core.domain.model.Vacancy
import com.example.core.domain.model.VacancyFeatureModel
// здесь обработка незаполненных полей если они пришли из JSON
class DataMapper {
    // Преобразование ResponseData в отдельные списки OfferFeatureModel и VacancyFeatureModel
    fun mapResponseToOffersAndVacancies(response: ResponseData): Pair<List<OfferFeatureModel>, List<VacancyFeatureModel>> {
        val offers = response.offers?.filterNotNull()?.map { mapToOfferFeatureModel(it) } ?: emptyList()
        val vacancies = response.vacancies?.filterNotNull()?.map { mapToVacancyFeatureModel(it) } ?: emptyList()
        return offers to vacancies
    }

    // Преобразование Offer в OfferFeatureModel
    private fun mapToOfferFeatureModel(offer: Offer): OfferFeatureModel {
        return OfferFeatureModel(
            id = offer.id ?: "",
            title = offer.title ?: "",
            link = offer.link ?: "",
            button = offer.button?.let { mapToButton(it) } ?: ButtonFeatureModel(text = "")
        )
    }

    // Преобразование Vacancy в VacancyFeatureModel
    private fun mapToVacancyFeatureModel(vacancy: Vacancy): VacancyFeatureModel {
        return VacancyFeatureModel(
            id = vacancy.id ?: "",
            title = vacancy.title ?: "",
            company = vacancy.company ?: "",
            salary = vacancy.salary?.let { mapToSalary(it) } ?: SalaryFeatureModel(full = "", short = ""),
            lookingNumber = vacancy.lookingNumber ?: 0,
            address = vacancy.address?.let { mapToAddress(it) } ?: AddressFeatureModel(town = "", street = "", house = ""),
            experience = vacancy.experience?.let { mapToExperience(it) } ?: ExperienceFeatureModel(previewText = "", text = ""),
            publishedDate = vacancy.publishedDate ?: "",
            isFavorite = vacancy.isFavorite ?: false,
            schedules = vacancy.schedules.orEmpty().filterNotNull(),
            appliedNumber = vacancy.appliedNumber ?: 0,
            description = vacancy.description ?: "",
            responsibilities = vacancy.responsibilities ?: "",
            questions = vacancy.questions.orEmpty().filterNotNull()
        )
    }

    // Маппинг Button из ResponseData

    private fun mapToButton(button: Button): ButtonFeatureModel {
        return ButtonFeatureModel(text = button.text ?: "")
    }

    // Маппинг Address из ResponseData
    private fun mapToAddress(address: Address): AddressFeatureModel {
        return AddressFeatureModel(town = address.town ?: "", street = address.street ?: "", house = address.house ?: "")
    }

    // Маппинг Experience из ResponseData
    private fun mapToExperience(experience: Experience): ExperienceFeatureModel {
        return ExperienceFeatureModel(previewText = experience.previewText ?: "", text = experience.text ?: "")
    }

    // Маппинг Salary из ResponseData
    private fun mapToSalary(salary: Salary): SalaryFeatureModel {
        return SalaryFeatureModel(full = salary.full ?: "", short = salary.short ?: "")
    }
}