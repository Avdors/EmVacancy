package com.example.mainlist.domain.model

class OfferMainFragmentModel(
    val id: String,
    val title: String,
    val link: String,
    val buttonText: String
){

val button = Button(text = buttonText)

}




class Button(

    val text: String? = null
)
