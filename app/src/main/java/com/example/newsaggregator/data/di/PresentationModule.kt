package com.example.newsaggregator.data.di

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.example.newsaggregator.ui.components.main.DefaultMainComponent
import com.example.newsaggregator.ui.components.main.MainComponent
import com.example.newsaggregator.ui.components.main.MainStoreFactory
import com.example.newsaggregator.ui.components.root.DefaultRootComponent
import com.example.newsaggregator.ui.components.root.RootComponent
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

private val storeFactoryModule = module {
    single<StoreFactory> { LoggingStoreFactory(DefaultStoreFactory()) }

    factoryOf(::MainStoreFactory)
}

private val componentModule = module {
    singleOf(::DefaultRootComponent) { bind<RootComponent>() }
    singleOf(::DefaultMainComponent) { bind<MainComponent>() }
}

internal val presentationModule = module {
    includes(
        storeFactoryModule,
        componentModule
    )
}