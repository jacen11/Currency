package com.pastukhov.chucknorris.data

import com.pastukhov.chucknorris.data.model.CurrencyModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("?api_key=hkh8PSNJeRGApDhQpSR9ce9D3uDGSn")
    fun getRate(@Query("from") from: String,
                @Query("to") to: String,
                @Query("amount") amount: String): Observable<CurrencyModel>
}