package com.example.news_then_and_now.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentNewsDto(

   // var data: List<CurrentNews>
    var author: String,
    var title: String,
    var description: String,
    var url: String,
    var source: String

) {

}
