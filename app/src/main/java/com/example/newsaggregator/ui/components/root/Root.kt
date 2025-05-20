package com.example.newsaggregator.ui.components.root

import com.arkivanov.decompose.ComponentContext
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf

object Root {

    fun params(
        context: ComponentContext
    ): ParametersDefinition = {
        parametersOf(
            context
        )
    }

}