package com.pastukhov.currency.business.model

data class CurrencyBusinessModel(
    var value: String
)

operator fun CurrencyBusinessModel.times(number: Int): CurrencyBusinessModel {
    this.value = (this.value.toInt() * number).toString()
    return this
}