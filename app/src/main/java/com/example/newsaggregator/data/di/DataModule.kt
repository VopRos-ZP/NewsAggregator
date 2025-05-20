package com.example.newsaggregator.data.di

import com.example.newsaggregator.data.rss.RssFeed
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import nl.adaptivity.xmlutil.serialization.XML
import okhttp3.MediaType
import org.koin.dsl.module
import retrofit2.Retrofit

private val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://www.theguardian.com")
            .addConverterFactory(
                XML.asConverterFactory(
                    MediaType.get("application/xml; charset=UTF8" )
                )
            ).build()
    }
    single<RssFeed> {
        get<Retrofit>().create(RssFeed::class.java)
    }
}

private val roomModule = module {

}

private val repositoryModule = module {

}

internal val dataModule = module {
    includes(
        roomModule,
        networkModule,
        repositoryModule,
    )
}