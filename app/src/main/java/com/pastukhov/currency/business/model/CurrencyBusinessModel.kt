package com.pastukhov.currency.business.model

data class CurrencyBusinessModel(
    var value: String
)

operator fun CurrencyBusinessModel.times(number: Double): CurrencyBusinessModel {
    this.value = (this.value.toDouble() * number).toString()
    return this
}