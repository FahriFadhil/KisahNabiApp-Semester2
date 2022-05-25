package com.fahri.kisahnabiapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.fahri.kisahnabiapp.data.network.ApiClient
import com.fahri.kisahnabiapp.data.response.NabiResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {

    val kisahResponse = MutableLiveData<List<NabiResponse>>()
    val isLoading = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Throwable>()

    fun getKisahNabi(responseHandler: (List<NabiResponse>) -> Unit, errorHandler: (Throwable) -> Unit) {
        ApiClient.getApiServices().getKisahNabi().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun getData() {
        isLoading.value = true

        getKisahNabi({
            isLoading.value = false
            kisahResponse.value = it
        }, {
            isLoading.value = false
            isError.value = it
        })
    }
}