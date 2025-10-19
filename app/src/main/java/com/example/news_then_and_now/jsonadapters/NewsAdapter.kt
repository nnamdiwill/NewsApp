package com.example.news_then_and_now.jsonadapters

import com.example.news_then_and_now.dataclasses.CurrentNews
import com.example.news_then_and_now.dto.CurrentNewsDto
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonQualifier
import com.squareup.moshi.ToJson


@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class WrappedNewsList
class NewsAdapter {

    @WrappedNewsList
    @FromJson
    fun fromJson(currentNewsDtoList: List<CurrentNewsDto>) : List<CurrentNews> = currentNewsDtoList.map {
            currentNewsDto ->
        CurrentNews(
            author = currentNewsDto.author,
            title = currentNewsDto.title,
            description = currentNewsDto.description,
            news = currentNewsDto.url,
            country = currentNewsDto.source,
            isUpdated = false
        )
    }




    @ToJson
    fun toJson(@WrappedNewsList currentNewsList: List<CurrentNews>): List<CurrentNewsDto> = currentNewsList.map { currentNews ->
        CurrentNewsDto(


            author = currentNews.author,
            title = currentNews.title,
            description =  currentNews.description,
           url =  currentNews.news,
           source =  currentNews.country

        )
    }




}