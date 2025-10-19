package com.example.news_then_and_now.repositories

import com.example.news_then_and_now.NewsService
import com.example.news_then_and_now.databases.NewsDAO
import com.example.news_then_and_now.dataclasses.CurrentNews
import com.example.news_then_and_now.prefs.NewsPrefs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow



class NewsRepositoryImpl(
    private val service: NewsService,
    private val dao: NewsDAO,
    private val prefs: NewsPrefs,
) :NewsRepository {
    // private var favorites = setOf<String>()
    private var updates = setOf<String>()
    private val _news: MutableStateFlow<List<CurrentNews>> = MutableStateFlow(emptyList())

    override val currentNews: StateFlow<List<CurrentNews>> = _news.asStateFlow()


    override suspend fun fetchNews() {

        val newsResponse = service.getCurrentNews()

        _news.value = emptyList()
        _news.value = try {
            if (newsResponse.isSuccessful) {
                newsResponse.body()!!
                    .toMutableList()
                    .map { currentNews ->
                        currentNews.copy(isUpdated = updates.contains(currentNews.news))
                    }
            } else {
                throw Throwable("Request failed: ${newsResponse.message()}")
            }
        } catch (e: Exception) {
            throw Throwable("Request failed: ${e.message}")
        }

    }

        override fun getNewsStory(index: Int): CurrentNews? =
            _news.value.getOrNull(index)

    override suspend fun breakingNews(news: CurrentNews) {
        updates = if (updates.contains(news.newsHeadline)) {
            updates - news.description
        } else {
            updates + news.description
        }
        val index = _news.value.indexOf(news)
        val mutableNews = _news.value.toMutableList()
        mutableNews[index] = mutableNews[index].copy(isUpdated = updates.contains(news.newsHeadline))
        _news.value = mutableNews.toList()
    }

    }


    /*
    package com.kodeco.android.countryinfo.repositories

import com.kodeco.android.countryinfo.models.Country
import com.kodeco.android.countryinfo.network.CountryService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CountryRepositoryImpl(
    private val service: CountryService,
) : CountryRepository {

    private var favorites = setOf<String>()

    private val _countries: MutableStateFlow<List<Country>> = MutableStateFlow(emptyList())
    override val countries: StateFlow<List<Country>> = _countries.asStateFlow()

    override suspend fun fetchCountries() {
        val countriesResponse = service.getAllCountries()

        _countries.value = emptyList()
        _countries.value = try {
            if (countriesResponse.isSuccessful) {
                countriesResponse.body()!!
                    .toMutableList()
                    .map { country ->
                        country.copy(isFavorite = favorites.contains(country.commonName))
                    }
            } else {
                throw Throwable("Request failed: ${countriesResponse.message()}")
            }
        } catch (e: Exception) {
            throw Throwable("Request failed: ${e.message}")
        }
    }

    override fun getCountry(index: Int): Country? =
        _countries.value.getOrNull(index)

    override suspend fun favorite(country: Country) {
        favorites = if (favorites.contains(country.commonName)) {
            favorites - country.commonName
        } else {
            favorites + country.commonName
        }
        val index = _countries.value.indexOf(country)
        val mutableCountries = _countries.value.toMutableList()
        mutableCountries[index] = mutableCountries[index].copy(isFavorite = favorites.contains(country.commonName))
        _countries.value = mutableCountries.toList()
    }
}

     */