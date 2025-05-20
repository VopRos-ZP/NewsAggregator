package com.example.newsaggregator.ui.components.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.example.newsaggregator.ui.components.ext.componentScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class DefaultMainComponent(
    private val storeFactory: MainStoreFactory,
    context: ComponentContext
) : MainComponent, ComponentContext by context {

    private val store = instanceKeeper.getStore { storeFactory.create() }
    private val scope = componentScope()
    override val model = store.stateFlow

    init {
        scope.launch {

        }
    }

    override fun onItemDetailsClick() {

    }

}