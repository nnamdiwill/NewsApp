package com.example.news_then_and_now.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.news_then_and_now.dataclasses.CurrentNews
import com.example.news_then_and_now.newsinfo.samples.oneSampleNews


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsRow(currentNews: CurrentNews,
            onClick: () -> Unit) {

    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
    ) {
        Column(modifier = Modifier.padding(all = 8.dp)) {
            Text(text = "news: ${currentNews.news}")
            Text(text = "Capital: ${currentNews.author}")
        }
    }
}

@Preview
@Composable
fun NewsRowPreview(){
    NewsRow(currentNews = oneSampleNews,
        onClick = {}
    )


}