package com.example.news_then_and_now

import com.example.news_then_and_now.dataclasses.CurrentNews
import com.example.news_then_and_now.dto.CurrentNewsDto
import retrofit2.Response
import retrofit2.http.GET

interface NewsService {

  //  val ACCESS_KEY:String = "616e41b563f236d505f281d4c9cc0911"

    @GET("v1/news?access_key=616e41b563f236d505f281d4c9cc0911&country=us")
    suspend fun getCurrentNews() : Response<List<CurrentNews>>



}