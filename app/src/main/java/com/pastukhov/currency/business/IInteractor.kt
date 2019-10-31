package com.pastukhov.currency.business

import com.pastukhov.currency.business.model.CurrencyBusinessModel
import io.reactivex.Observable

interface IInteractor {

    fun getCurrency(from: String, to: String, amount: String): Observable<CurrencyBusinessModel>
}