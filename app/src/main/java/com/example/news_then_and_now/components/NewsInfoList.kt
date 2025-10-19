package com.example.news_then_and_now.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.news_then_and_now.R
import com.example.news_then_and_now.dataclasses.CurrentNews


@Composable
fun NewsInfoList(
    news: List<CurrentNews>,
    onRefreshTap: () -> Unit,
    onNewsRowTap: (CurrentNews) -> Unit,
onNewsRowFavorite: (currentNews:CurrentNews) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            AButton(onClick = onRefreshTap, modifier = Modifier) {
                Atext(text = stringResource(id = R.string.placement))
            }
        }

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(news) { index, currentNews ->
                NewsRow(
                    currentNews = currentNews,
                    onClick = {
                        onNewsRowTap(index)
                    }

                )
            }
        }
    }
}




