package com.example.news_then_and_now.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.news_then_and_now.dataclasses.CurrentNews
import com.example.news_then_and_now.models.NewsDetailScreen
import com.example.news_then_and_now.models.NewsDetailViewModel
import com.example.news_then_and_now.newsinfo.samples.sampleNews
import com.example.news_then_and_now.repositories.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsList(
    news: List<CurrentNews>,
    onRefresh: () -> Unit,

) {
    var selectedNewsStory: CurrentNews? by remember { mutableStateOf(null) }
    var tapCounter by remember { mutableIntStateOf(0) }
    var backCounter by remember { mutableIntStateOf(0) }
    var navController = NavController


    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Taps: $tapCounter",
                textAlign = TextAlign.Start,
            )
            Button(
                onClick = onRefresh,
            ) {
                Text(text = "Refresh")
            }
            Text(
                text = "Back: $backCounter",
                textAlign = TextAlign.End,
            )
        }




        selectedNewsStory?.let { news ->

            NewsDetailScreen(
                viewModel = viewModel(
                    factory = NewsDetailViewModel.NewsDetailsViewModelFactory(
                        newsId = 0,
                        repository = object : NewsRepository {
                           override val currentNews: Flow<List<CurrentNews>>
                               get() = MutableStateFlow(sampleNews).asStateFlow()
                            /*
                             override val countries: Flow<List<Country>>
                    get() = MutableStateFlow(sampleCountries).asStateFlow()
                             */
                            override suspend fun fetchNews()  {
                               // emit(sampleNews)
                            }

                            override fun getNewsStory(index: Int): CurrentNews? {
                                return sampleNews.getOrNull(index)
                            }

                            override suspend fun breakingNews(currentNews: CurrentNews) {
                                TODO("Not yet implemented")
                            }
                        }

                    )

                ),
                onNavigateUp = { navController }
            )
        }
            ?: run {
                LazyColumn {
                    items(news) { news ->
                        NewsRow(news) {
                            selectedNewsStory = news
                            tapCounter++
                        }
                    }
                }
            }
    }

}
@Preview
@Composable
fun CountryInfoListPreview() {
    NewsList(
        news = sampleNews,
        onRefresh = {},
    )
}

