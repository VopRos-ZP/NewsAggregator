package com.example.newsaggregator.data.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject
import org.koin.core.parameter.ParametersHolder

inline fun <reified T> KoinComponent.injectComponent(
    parameters: ParametersHolder
): Lazy<T> = inject(parameters = { parameters })

inline fun <reified T> KoinComponent.getComponent(
    parameters: ParametersHolder
): T = get(parameters = { parameters })