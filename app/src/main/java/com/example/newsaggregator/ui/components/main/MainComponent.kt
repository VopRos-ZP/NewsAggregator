package com.example.newsaggregator.ui.components.main

import kotlinx.coroutines.flow.StateFlow

interface MainComponent {
    val model: StateFlow<Main.State>

    fun onItemDetailsClick()

}