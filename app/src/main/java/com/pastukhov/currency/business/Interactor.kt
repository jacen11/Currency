package com.pastukhov.chucknorris.business

import com.pastukhov.currency.business.model.CurrencyBusinessModel
import com.pastukhov.currency.business.IInteractor
import com.pastukhov.currency.business.model.times
import com.pastukhov.currency.data.ApiService
import com.pastukhov.currency.data.map
import com.pastukhov.currency.data.model.CurrencyModel
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Interactor @Inject constructor(private val service: ApiService) : IInteractor {

    override fun getCurrency(
        from: String,
        to: String,
        amount: String
    ): Single<CurrencyBusinessModel> =
        service.getRate("${from}_$to").map { map(it) * amount.toDouble() }

}