package com.example.newsaggregator.ui.components.main

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory
import com.example.newsaggregator.data.rss.RssFeed
import com.example.newsaggregator.ui.components.main.Main.Intent
import com.example.newsaggregator.ui.components.main.Main.Action
import com.example.newsaggregator.ui.components.main.Main.Label
import com.example.newsaggregator.ui.components.main.Main.State
import com.example.newsaggregator.ui.components.main.Main.Msg
import kotlinx.coroutines.launch

class MainStoreFactory(
    private val storeFactory: StoreFactory,
    private val rssFeed: RssFeed
) {

    fun create(): MainStore = object : MainStore,
        Store<Intent, State, Label> by storeFactory.create<Intent, Action, Msg, State, Label>(
            name = "MainStore",
            initialState = State(),
            bootstrapper = coroutineBootstrapper {
                launch {
                    dispatch(Action.OnRssChange(rssFeed.getRss()))
                }
            },
            executorFactory = coroutineExecutorFactory {
                onAction<Action.OnRssChange> {
                    dispatch(Msg.OnRssChange(it.value))
                }
            },
            reducer = {
                when (it) {
                    is Msg.OnRssChange -> copy(rssDto = it.value)
                }
            }
        ) {}

}