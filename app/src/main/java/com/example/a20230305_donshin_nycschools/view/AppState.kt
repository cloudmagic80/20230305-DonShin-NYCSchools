package com.example.a20230305_donshin_nycschools.view

import com.example.a20230305_donshin_nycschools.model.School
import com.example.a20230305_donshin_nycschools.model.SchoolDetail


sealed interface AppState {
    data class Success(
        val schools: List<School>,
        val schoolsDetails: List<SchoolDetail>
    ) : AppState

    object Error : AppState
    object Loading : AppState
}

data class UiState(
    val selectedSchoolDetail: SchoolDetail ? = null
)

enum class Screen {
    Main, Details
}

