package com.example.news_then_and_now.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.news_then_and_now.dataclasses.CurrentNews
import com.example.news_then_and_now.samples.sampleNews

@Composable
fun NewsDetails(
currentNews: CurrentNews,
modifier: Modifier
) {
    LazyColumn(modifier = Modifier) {
        item { Text(text = "HeadLine: ${currentNews.news}",color = Color.Blue) }
        item { Text(text = "Details:  ${currentNews.description}", color = Color.Green) }
        item { Text(text = "Author:  ${currentNews.author}", color = Color.Red) }
        item {
            var expanded by remember { mutableStateOf(false) }

        }

    }
}

@Preview
@Composable
fun NewsDetailsPreview() {

        NewsDetails(
            currentNews = sampleNews,
            modifier = Modifier,
        )
    }

