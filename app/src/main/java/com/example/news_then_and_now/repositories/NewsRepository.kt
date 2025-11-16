package com.example.news_then_and_now.repositories

import com.example.news_then_and_now.dataclasses.CurrentNews
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    val currentNews: Flow<CurrentNews>
   suspend fun  fetchNews()
    fun getNewsStory(index: Int): CurrentNews?
    suspend fun breakingNews(currentNews: CurrentNews)
   // fun fetchCurrentNews()
}