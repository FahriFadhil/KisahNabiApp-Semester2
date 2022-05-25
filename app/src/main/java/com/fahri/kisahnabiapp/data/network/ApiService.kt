package com.fahri.kisahnabiapp.data.network

import com.fahri.kisahnabiapp.data.response.NabiResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("kisahnabi")
    fun getKisahNabi() : Flowable<List<NabiResponse>>

}