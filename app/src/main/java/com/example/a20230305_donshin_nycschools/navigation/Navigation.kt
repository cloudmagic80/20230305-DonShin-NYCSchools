package com.example.a20230305_donshin_nycschools.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.a20230305_donshin_nycschools.model.School
import com.example.a20230305_donshin_nycschools.model.SchoolDetail
import com.example.a20230305_donshin_nycschools.view.AppState
import com.example.a20230305_donshin_nycschools.view.Screen
import com.example.a20230305_donshin_nycschools.view.UiState
import com.example.a20230305_donshin_nycschools.view.screens.details.DetailsScreen
import com.example.a20230305_donshin_nycschools.view.screens.main.MainScreen

@Composable
fun NavigationComponent(
    modifier: Modifier = Modifier,
    appState: AppState,
    uiState: State<UiState>,
    navController: NavHostController,
    getSchoolsData: () -> Unit,
    seeDetails: (School, List<SchoolDetail>) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.toString(),
        modifier = modifier
    ) {
        composable(Screen.Main.toString()) {
            MainScreen(
                modifier = modifier,
                appState = appState,
                getSchoolsData = { getSchoolsData() },
                seeDetails = { schoolSelected, schoolsDetails ->
                    seeDetails(schoolSelected, schoolsDetails)
                },
            )
        }
        composable(Screen.Details.toString()) {
            DetailsScreen(
                modifier = modifier,
                appState = appState,
                uiState = uiState,
                retryAction = { getSchoolsData() },
            )
        }
    }
}

