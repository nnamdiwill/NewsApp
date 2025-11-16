package com.example.news_then_and_now.ui.theme.screens.newsList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_then_and_now.prefs.NewsPrefs
import com.example.news_then_and_now.repositories.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
@HiltViewModel
class CountryListViewModel @Inject constructor(
    private val repository: CountryRepository,
    private val prefs: CountryPrefs,
) : ViewModel() {

    private var isFavoritesFeatureEnabled = false
        set(value) {
            field = value
            val uiStateValue = _uiState.value
            if (uiStateValue is CountryListState.Success) {
                _uiState.value = uiStateValue.copy(isFavoritesFeatureEnabled = value)
            }
        }

    private val _uiState = MutableStateFlow<CountryListState>(CountryListState.Loading)
    val uiState: StateFlow<CountryListState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            prefs.getFavoritesFeatureEnabled()
                .collect { favoritesFeatureEnabled ->
                    isFavoritesFeatureEnabled = favoritesFeatureEnabled
                }
        }

        viewModelScope.launch {
            repository
                .countries
                .catch {
                    _uiState.value = CountryListState.Error(it)
                }
                .collect {
                    _uiState.value = CountryListState.Success(
                        countries = it,
                        isFavoritesFeatureEnabled = isFavoritesFeatureEnabled,
                    )
                }
        }

        fetchCountries()
    }

    fun fetchCountries() {
        _uiState.value = CountryListState.Loading

        viewModelScope.launch {
            try {
                repository.fetchCountries()
            } catch (e: Exception) {
                _uiState.value = CountryListState.Error(e)
            }
        }
    }

    fun favorite(country: Country) {
        viewModelScope.launch {
            repository.favorite(country)
        }
    }
}

 */

class NewsListViewModel @Inject constructor(
    private val repository: NewsRepository,
    private val prefs: NewsPrefs,
) : ViewModel() {

    private var isFavoritesFeatureEnabled = false
        set(value) {
            field = value
            val uiStateValue = _uiState.value
            if (uiStateValue is NewsListState.Success) {
                _uiState.value = uiStateValue.copy(isFavoritesFeatureEnabled = value)
            }
        }

    private val _uiState = MutableStateFlow<NewsListState>(NewsListState.Loading)
    val uiState: StateFlow<NewsListState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            prefs.getFavoritesFeatureEnabled()
                .collect { favoritesFeatureEnabled ->
                    isFavoritesFeatureEnabled = favoritesFeatureEnabled
                }
        }

        viewModelScope.launch {
            repository
                .currentNews
                .catch {
                    _uiState.value = NewsListState.Error(it)
                }
                .collect {
                    _uiState.value = NewsListState.Success(
                        news = it,
                        isFavoritesFeatureEnabled = isFavoritesFeatureEnabled,
                    )
                }
        }

        fetchNews()
    }

    fun fetchNews() {
        _uiState.value = NewsListState.Loading

        viewModelScope.launch {
            try {
                repository.fetchNews()
            } catch (e: Exception) {
                _uiState.value = NewsListState.Error(e)
            }

        }

    }
}
