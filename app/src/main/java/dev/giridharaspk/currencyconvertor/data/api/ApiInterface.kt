package dev.giridharaspk.currencyconvertor.data.api

import dev.giridharaspk.currencyconvertor.data.model.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("latest.json")
    suspend fun getLatestJson(@Query("app_id") apiKey: String): Response<CurrencyResponse>

}