package com.example.wekeza_app.data

import android.view.SurfaceControl
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "192.168.0.110/http://127.0.0.1:8000/api"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()


interface ApiService {
    @GET("transactions")
    fun getTransactions() :
            Call<SurfaceControl.Transaction>
 }

object WekezaApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
