package dev.giridharaspk.currencyconvertor.data.repo

import android.util.Log
import dev.giridharaspk.currencyconvertor.data.api.RetrofitInstance
import dev.giridharaspk.currencyconvertor.data.model.CurrencyResponse
import retrofit2.Response

object CurrencyRepository {

    val TAG = "CurrencyRepository"

    suspend fun getCurrencyExchangeJson(): Response<CurrencyResponse> {
        Log.d(TAG, "getImages REST Api call")
        return RetrofitInstance.api.getLatestJson("3a29eb27a45d4338b959f3b6e1a6233e")
    }

}