package com.example.news_then_and_now.ui.theme.screens.newsDetails

import com.example.news_then_and_now.dataclasses.CurrentNews


sealed class NewsDetailsState {

    data object Loading : NewsDetailsState()
    data class Success(val news: CurrentNews?) : NewsDetailsState()
    data class Error(val error: Throwable) : NewsDetailsState()
}