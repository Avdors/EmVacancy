package com.example.core.domain.model


import com.example.mainlist.domain.model.ExperienceMainFragmentModel


class ExperienceCoreModel(
    private val previewText: String,
    private val text: String
) {
    fun toMainFragmentModel(): ExperienceMainFragmentModel {
        return ExperienceMainFragmentModel(
            previewText = previewText,
            text = text
        )
    }
}