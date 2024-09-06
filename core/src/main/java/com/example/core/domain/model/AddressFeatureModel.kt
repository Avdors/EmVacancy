package com.example.core.domain.model

import com.example.mainlist.domain.model.AddressMainFragmentModel


class AddressFeatureModel(
   private val town: String,
   private val street: String,
   private val house: String
) {
   fun toMainFragmentModel(): AddressMainFragmentModel {
      return AddressMainFragmentModel(
         town = town,
         street = street,
         house = house
         )
   }
}