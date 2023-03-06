package com.example.a20230305_donshin_nycschools.view.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a20230305_donshin_nycschools.R
import com.example.a20230305_donshin_nycschools.model.SchoolDetail

@Composable
fun DetailCard(
    schoolDetailData: SchoolDetail
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxSize(),
        elevation = 4.dp,
        backgroundColor = Color.Yellow,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(modifier = Modifier.padding(20.dp)) {
            Column(
                modifier = Modifier.weight(1f),
                Arrangement.SpaceAround
            ) {
                Text(
                    text = schoolDetailData.schoolName,
                    style = TextStyle(
                        color = Color.Blue,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(
                    text = stringResource(
                        R.string.satMathAvgScore,
                        schoolDetailData.satMathAvgScore
                    ),
                    style = TextStyle(
                        color = Color.Blue,
                        fontSize = 15.sp
                    )
                )
                Text(
                    text = stringResource(
                        R.string.satCriticalReadingAvgScore,
                        schoolDetailData.satCriticalReadingAvgScore
                    ),
                    style = TextStyle(
                        color = Color.Blue,
                        fontSize = 15.sp
                    )
                )
                Text(
                    text = stringResource(
                        R.string.satWritingAvgScore,
                        schoolDetailData.satWritingAvgScore
                    ),
                    style = TextStyle(
                        color = Color.Blue,
                        fontSize = 15.sp
                    )
                )
                Text(
                    text = stringResource(
                        R.string.numOfSatTestTakers,
                        schoolDetailData.numOfSatTestTakers
                    ),
                    style = TextStyle(
                        color = Color.Blue,
                        fontSize = 15.sp

                    )
                )
                schoolDetailData.overview?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 10.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold

                        )

                    )
                }
            }
        }
    }
}