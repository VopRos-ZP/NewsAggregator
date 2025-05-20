package com.example.newsaggregator.data.di

import org.koin.dsl.module

val appModule = module {
    includes(
        dataModule,
        domainModule,
        presentationModule,
    )
}