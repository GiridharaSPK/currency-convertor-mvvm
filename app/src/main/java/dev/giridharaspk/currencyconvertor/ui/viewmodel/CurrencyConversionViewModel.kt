package dev.giridharaspk.currencyconvertor.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.giridharaspk.currencyconvertor.data.api.ApiResult
import dev.giridharaspk.currencyconvertor.data.model.CurrencyResponse
import dev.giridharaspk.currencyconvertor.data.repo.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import java.net.UnknownHostException

class CurrencyConversionViewModel(val repo: CurrencyRepository) : ViewModel() {

    val TAG = "CurrencyConversionViewModel"

    val response = MutableLiveData<ApiResult<CurrencyResponse>>()

    init {
        getCurrencyData()
    }

    private fun getCurrencyData() = viewModelScope.launch(Dispatchers.IO) {
        response.postValue(ApiResult.Loading())
        try {
            val response = repo.getCurrencyExchangeJson()
            response.postValue(handleCurrencyResponse(response))
        } catch (e: UnknownHostException) {
            response.postValue(ApiResult.NetworkError(e))
        } catch (e: IOException) {
            response.postValue(ApiResult.NetworkError(e))
        } catch (e: Exception) {
            response.postValue(ApiResult.Error(e))
        }
    }

    private fun handleCurrencyResponse(resp: Response<CurrencyResponse>): ApiResult<CurrencyResponse> {
        Log.d(TAG, "handleImagesResponse $resp")
        return if (resp.isSuccessful) {
            ApiResult.Success(resp.body()!!)
        } else {
            ApiResult.Failure(resp.message())
        }
    }

}