package com.pastukhov.chucknorris.business

import com.pastukhov.currency.business.model.CurrencyBusinessModel
import com.pastukhov.currency.business.IInteractor
import com.pastukhov.currency.data.ApiService
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Interactor @Inject constructor(val service: ApiService) : IInteractor {

    override fun getCurrency(): Observable<CurrencyBusinessModel> {
       TODO()
    }
}