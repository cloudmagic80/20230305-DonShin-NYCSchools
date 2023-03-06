package com.example.a20230305_donshin_nycschools.dataManager.network

import com.example.a20230305_donshin_nycschools.dataManager.AppRepository
import com.example.a20230305_donshin_nycschools.model.School
import com.example.a20230305_donshin_nycschools.model.SchoolDetail

//This class help us to call the api services to update our app repository
class NetworkAppRepository(
    private val appApiService: AppApiService
): AppRepository {

    override suspend fun getSchoolsData(): ArrayList<School> = appApiService.getSchoolsData()
    override suspend fun getSchoolsDetailsData(): ArrayList<SchoolDetail> = appApiService.getSchoolsDetailsData()
}