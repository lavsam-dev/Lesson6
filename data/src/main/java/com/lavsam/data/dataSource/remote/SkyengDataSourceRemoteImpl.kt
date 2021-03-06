package com.lavsam.data.dataSource.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.lavsam.data.dataSource.api.ApiService
import com.lavsam.data.dataSource.interceptor.BaseInterceptor
import com.lavsam.model.SkyengDataModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://dictionary.skyeng.ru/api/public/v1/"

class SkyengDataSourceRemoteImpl : SkyengDataSourceRemote<List<SkyengDataModel>> {

    override suspend fun getData(word: String): List<SkyengDataModel> =
        getService(BaseInterceptor.interceptor).searchAsync(word).await()

    private fun getService(interceptor: Interceptor): ApiService =
        createRetrofit(interceptor).create(ApiService::class.java)

    private fun createRetrofit(interceptor: Interceptor): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(createOkHttpClient(interceptor))
        .build()

    private fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return httpClient.build()
    }
}