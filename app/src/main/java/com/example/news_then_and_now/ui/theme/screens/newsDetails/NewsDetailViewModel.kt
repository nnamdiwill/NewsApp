package com.example.news_then_and_now.ui.theme.screens.newsDetails


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.news_then_and_now.dataclasses.CurrentNews
import com.example.news_then_and_now.repositories.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NewsDetailViewModel(
    private val newsId: Int,
    private val repository: NewsRepository
) : ViewModel()  {

    var news: CurrentNews? = null
 //   private val _uptimeCounter = MutableStateFlow(0)
    private val _uiState = MutableStateFlow<NewsDetailsState>(NewsDetailsState.Loading)

    val uiState: StateFlow<NewsDetailsState> = _uiState

    init {

        _uiState.value = NewsDetailsState.Success(repository.getNewsStory(newsId))
        news = repository.getNewsStory(newsId)

    }

    class NewsDetailsViewModelFactory(
        private val  newsId:Int,
        private val repository: NewsRepository) :
        ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            NewsDetailViewModel(newsId,repository) as T
    }


}