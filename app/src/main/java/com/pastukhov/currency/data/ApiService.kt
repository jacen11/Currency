package com.pastukhov.currency.data

import com.pastukhov.currency.data.model.CurrencyModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @GET("?api_key=6bfeb100c4be1ee184fc&compact=y&q=from_to")
    fun getRate(
        @Query("from") from: String,
        @Query("to") to: String
    ): Observable<CurrencyModel>
}