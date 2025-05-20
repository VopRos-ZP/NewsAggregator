package com.example.newsaggregator.ui.components.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.example.newsaggregator.ui.components.details.DetailsComponent
import com.example.newsaggregator.ui.components.main.MainComponent

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>

    sealed interface Child {
        data class Main(val component: MainComponent) : Child
        data class Details(val component: DetailsComponent) : Child
    }

}