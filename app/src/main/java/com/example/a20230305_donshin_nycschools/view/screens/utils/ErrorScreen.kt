package com.example.a20230305_donshin_nycschools.view.screens.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.a20230305_donshin_nycschools.R
import com.example.a20230305_donshin_nycschools.view.AppState


@Composable
fun ErrorScreen(
    modifier: Modifier,
    retryAction: () -> Unit,
    appState: AppState.Error,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.loading_failed))
        Button(onClick = retryAction) {
            Text(text = "Reload data")
        }
    }

}
