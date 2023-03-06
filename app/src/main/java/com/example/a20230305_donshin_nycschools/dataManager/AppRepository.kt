package com.example.a20230305_donshin_nycschools.dataManager

import com.example.a20230305_donshin_nycschools.model.School
import com.example.a20230305_donshin_nycschools.model.SchoolDetail

interface AppRepository {
    suspend fun getSchoolsData(): List<School>
    suspend fun getSchoolsDetailsData(): List<SchoolDetail>
}
