package com.example.a20230305_donshin_nycschools.dataManager.network

import com.example.a20230305_donshin_nycschools.model.School
import com.example.a20230305_donshin_nycschools.model.SchoolDetail
import retrofit2.http.GET

interface AppApiService {

    //Here retrofit help us creating the code to call get
    @GET("resource/s3k6-pzi2.json")
    suspend fun getSchoolsData(): ArrayList<School>

    @GET("resource/f9bf-2cp4.json")
    suspend fun getSchoolsDetailsData(): ArrayList<SchoolDetail>
}