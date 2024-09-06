package com.example.core.domain.model


import com.example.mainlist.domain.model.VacancyMainFragmentModel


class VacancyFeatureModel(
    private val id: String,
    private val lookingNumber: Int,
    private val title: String,
    private val address: AddressFeatureModel,
    private val company: String,
    private val experience: ExperienceFeatureModel,
    private val publishedDate: String,
    private val isFavorite: Boolean,
    private val salary: SalaryFeatureModel,
    private val schedules: List<String>,
    private val appliedNumber: Int,
    private val description: String,
    private val responsibilities: String,
    private val questions: List<String>
){

    fun toFeatureModel(): VacancyMainFragmentModel {

        // Преобразование VacancyFeatureModel в VacancyMainFragmentModel
        return VacancyMainFragmentModel(
            id = this.id,
            lookingNumber = this.lookingNumber,
            title = this.title,
            address = this.address.toMainFragmentModel(),  // Преобразуем AddressFeatureModel в модель фрагмента
            company = this.company,
            experience = this.experience.toMainFragmentModel(),  // Преобразуем ExperienceFeatureModel в модель фрагмента
            publishedDate = this.publishedDate,
            isFavorite = this.isFavorite,
            salary = this.salary.toMainFragmentModel(),  // Преобразуем SalaryFeatureModel в модель фрагмента
            schedules = this.schedules,
            appliedNumber = this.appliedNumber,
            description = this.description,
            responsibilities = this.responsibilities,
            questions = this.questions

        )
    }

}




