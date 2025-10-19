package com.example.news_then_and_now.ui.theme.screens

import com.example.news_then_and_now.dataclasses.CurrentNews



sealed class NewsListState{
    data object Loading : NewsListState()
    data class Success(
        val news: List<CurrentNews>,
    ) : NewsListState()
    data class Error(val error: Throwable) : NewsListState()

}