package com.pastukhov.currency.business

import com.pastukhov.currency.business.model.CurrencyBusinessModel
import io.reactivex.Observable
import io.reactivex.Single

interface IInteractor {

    fun getCurrency(from: String, to: String, amount: String): Single<CurrencyBusinessModel>
}