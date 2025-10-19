package com.example.news_then_and_now.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NewsInfoLoadingList(

) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {

            AButton(
                onClick = {},
                modifier = Modifier,
            ) {
                Atext(text = "       ")
            }
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            NewsInfoLoadingRow()
            NewsInfoLoadingRow()
            NewsInfoLoadingRow()
            NewsInfoLoadingRow()
            NewsInfoLoadingRow()
        }
    }


}





/*/