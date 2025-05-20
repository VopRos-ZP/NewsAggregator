package com.example.newsaggregator.data.di

import org.koin.dsl.module

private val useCaseModule = module {

}

internal val domainModule = module {
    includes(
        useCaseModule
    )
}