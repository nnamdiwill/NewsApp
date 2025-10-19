package com.example.news_then_and_now.dto

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NewsNameDto(
    var name:String
)