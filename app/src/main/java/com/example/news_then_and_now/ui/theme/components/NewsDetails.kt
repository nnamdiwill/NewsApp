package com.example.news_then_and_now.ui.theme.components

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.news_then_and_now.currentNews
import com.example.news_then_and_now.dataclasses.CurrentNews
import com.example.news_then_and_now.samples.sampleNews

/*
@Composable
fun CountryDetails(
    country: Country,
    modifier: Modifier,
) {
    LazyColumn(modifier = modifier) {
        item { Text(text = "Capital: ${country.mainCapital}") }
        item { Text(text = "Population: ${country.population}") }
        item { Text(text = "Area: ${country.area}") }
        item {
            var expanded by remember { mutableStateOf(false) }
            val flagTransition = updateTransition(
                targetState = expanded,
                label = "${country.commonName}_details_transition",
            )
            val widthAnimation by flagTransition.animateDp(
                label = "${country.commonName}_details_size",
            ) { state ->
                if (state) {
                    300.dp
                } else {
                    150.dp
                }
            }
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(country.flagUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Flag",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .border(1.dp, color = MaterialTheme.colorScheme.primary)
                    .width(widthAnimation)
                    .clickable { expanded = !expanded },
            )
        }
    }
}

@Preview
@Composable
fun CountryDetailsPreview() {
    MyApplicationTheme {
        CountryDetails(
            country = sampleCountry,
            modifier = Modifier,
        )
    }
}

 */


@Composable
fun NewsDetails(
    currentNews: CurrentNews,
    modifier: Modifier
) {

    LazyColumn(modifier = modifier) {
        item { Text(text = "Headline: ${currentNews.newsHeadline}") }
        item { Text(text = "Author: ${currentNews.author}") }
        item { Text(text = "Country: ${currentNews.country}") }
        item {
            var expanded by remember { mutableStateOf(false) }
            val flagTransition = updateTransition(
                targetState = expanded,
                label = "${currentNews.newsHeadline}_details_transition",
            )
            val widthAnimation by flagTransition.animateDp(
                label = "${currentNews.description}_details_size",
            ) { state ->
                if (state) {
                    300.dp
                } else {
                    150.dp
                }
            }

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(currentNews.author)
                    .crossfade(true)
                    .build(),
                contentDescription = "Flag",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .border(1.dp, color = MaterialTheme.colorScheme.primary)
                    .width(widthAnimation)
                    .clickable { expanded = !expanded },
            )
        }
    }
}


@Preview
@Composable
fun NewsDetailsPreview() {

        NewsDetails(
            currentNews = sampleNews,
            modifier = Modifier,
        )
    }

