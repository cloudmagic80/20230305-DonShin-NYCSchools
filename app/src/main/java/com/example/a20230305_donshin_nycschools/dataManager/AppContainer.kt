package com.example.a20230305_donshin_nycschools.dataManager

import com.example.a20230305_donshin_nycschools.dataManager.network.AppApiService
import com.example.a20230305_donshin_nycschools.dataManager.network.NetworkAppRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val appRepository: com.example.a20230305_donshin_nycschools.dataManager.AppRepository
}

class DefaultAppContainer : com.example.a20230305_donshin_nycschools.dataManager.AppContainer {

    private val BASE_URL = "https://data.cityofnewyork.us/"

    //Here we configure the Json object to ignore unknown keys,
    //since there are way more that the ones used for this assignment
    private val json = Json {
        ignoreUnknownKeys = true
    }


    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    private val retrofitService: AppApiService by lazy {
        retrofit.create(AppApiService::class.java)
    }

    override val appRepository: com.example.a20230305_donshin_nycschools.dataManager.AppRepository by lazy {
        NetworkAppRepository(retrofitService)
    }
}