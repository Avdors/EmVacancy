package com.example.core.domain.model

import com.example.mainlist.domain.model.SalaryMainFragmentModel


class SalaryFeatureModel(
    private val full: String,

    private val short: String
) {
    fun toMainFragmentModel(): SalaryMainFragmentModel {
        return SalaryMainFragmentModel(
            full = full,
            short = short
        )
    }

}