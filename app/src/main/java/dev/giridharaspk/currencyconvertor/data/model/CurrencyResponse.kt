package dev.giridharaspk.currencyconvertor.data.model

data class CurrencyResponse(
    val base: String,
    val disclaimer: String,
    val license: String,
    val rates: Rates,
    val timestamp: Int
)