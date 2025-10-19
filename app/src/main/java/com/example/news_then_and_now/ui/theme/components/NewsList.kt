package com.example.news_then_and_now.ui.theme.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import com.example.news_then_and_now.dataclasses.CurrentNews


@Composable
fun NewsList(

    newsInfo: List<CurrentNews>,
    onRefresh: () -> Unit
){
    var showNews: CurrentNews? by rememberSaveable{  mutableStateOf(null) }
    Column {

        Row {

            Button(
                onClick = onRefresh,
            ) {
                Text(text = "Refresh")
            }
            Text(
                text = "Back: ",
                textAlign = TextAlign.End,
            )
        }
        LazyColumn() {

        }
    }
    showNews.let {

    }
}



