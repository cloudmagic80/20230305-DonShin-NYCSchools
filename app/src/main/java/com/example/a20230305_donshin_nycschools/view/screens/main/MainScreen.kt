package com.example.a20230305_donshin_nycschools.view.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.a20230305_donshin_nycschools.model.School
import com.example.a20230305_donshin_nycschools.model.SchoolDetail
import com.example.a20230305_donshin_nycschools.view.AppState
import com.example.a20230305_donshin_nycschools.view.screens.utils.ErrorScreen
import com.example.a20230305_donshin_nycschools.view.screens.utils.LoadingScreen


@Composable
fun MainScreen(
    appState: AppState,
    getSchoolsData: () -> Unit,
    seeDetails: (School, List<SchoolDetail>) -> Unit,
    modifier: Modifier = Modifier
) {
    when (appState) {
        is AppState.Loading -> LoadingScreen(modifier)
        is AppState.Success -> SchoolsListScreen(
            modifier = modifier,
            schoolsList = appState.schools,
            seeDetails = { schoolSelected ->
                seeDetails(schoolSelected, appState.schoolsDetails)
            }
        )
        is AppState.Error -> ErrorScreen(modifier, getSchoolsData, appState)
    }
}

@Composable
fun SchoolsListScreen(
    modifier: Modifier,
    schoolsList: List<School>,
    seeDetails: (School) -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {}
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colors.background
        ) {

            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(schoolsList) { schoolData ->
                    SchoolCard(
                        schoolData = schoolData,
                        seeDetails = { schoolSelected -> seeDetails(schoolSelected) }
                    )
                }
            }
        }
    }
}