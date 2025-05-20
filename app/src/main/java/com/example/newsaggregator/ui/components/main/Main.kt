package com.example.newsaggregator.ui.components.main

import com.example.newsaggregator.data.rss.dto.RssDto

object Main {

    data class State(
        val rssDto: RssDto? = null,
    )

    sealed interface Intent {

    }

    sealed interface Label {

    }

    sealed interface Action {
        data class OnRssChange(val value: RssDto) : Action
    }

    sealed interface Msg {
        data class OnRssChange(val value: RssDto) : Msg
    }

}