package com.example.news_then_and_now.newsinfo

import com.example.news_then_and_now.dataclasses.CurrentNews

sealed class NewsInfoState {

    data class Loading() : NewsInfoState()
    data class Success(val newsLinks: List<CurrentNews>) : NewsInfoState()
    data class Error(val error: Throwable,val userFriendlyMessageText: String) :NewsInfoState()



}


