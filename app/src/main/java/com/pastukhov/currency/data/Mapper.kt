package com.pastukhov.currency.data

import com.pastukhov.currency.business.model.CurrencyBusinessModel
import com.pastukhov.currency.data.model.CurrencyModel

fun map(model: CurrencyModel) = CurrencyBusinessModel(model.value)