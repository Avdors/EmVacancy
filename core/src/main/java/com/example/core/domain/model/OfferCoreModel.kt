package com.example.core.domain.model

import com.example.mainlist.domain.model.OfferMainFragmentModel


class OfferCoreModel(
    private val id: String,
    private val title: String,
    private val link: String,
    private val button: ButtonCoreModel
){

    fun toFeatureModel(): OfferMainFragmentModel {


        return OfferMainFragmentModel(

            id = this.id,
            title = this.title,
            link = this.link,
            buttonText = this.button.text.toString()
        )
    }

}