package com.example.news_then_and_now.ui.theme.screens

sealed interface FirstScreen {
    val path: String

    data object List : FirstScreen {
        override val path = "list"
    }

    data object Details : FirstScreen {
        override val path = "details"
    }

    data object About : FirstScreen {
        override val path = "about"
    }

    data object Settings : FirstScreen {
        override val path = "settings"
    }
}
