package com.pastukhov.currency.data

import com.pastukhov.currency.data.model.CurrencyModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/api/v7/convert")
    fun getRate(
        @Query("q") q: String
    ): Observable<CurrencyModel>
}