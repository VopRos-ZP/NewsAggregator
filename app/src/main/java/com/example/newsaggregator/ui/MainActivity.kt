package com.example.newsaggregator.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import com.example.newsaggregator.ui.components.root.RootScreen
import com.example.newsaggregator.ui.theme.NewsAggregatorTheme
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinAndroidContext {
                NewsAggregatorTheme {
                    RootScreen(
                        koinInject(
                            parametersHolder = parametersOf(
                                defaultComponentContext()
                            )
                        )
                    )
                }
            }
        }
    }

}
