package com.example.newsaggregator.ui.components.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.value.Value
import com.example.newsaggregator.data.di.getComponent
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent
import org.koin.core.parameter.parametersOf

class DefaultRootComponent(
    context: ComponentContext
) : RootComponent, KoinComponent, ComponentContext by context {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Main,
        handleBackButton = true,
        childFactory = ::childFactory
    )

    private fun childFactory(config: Config, context: ComponentContext): RootComponent.Child =
        when (config) {
            is Config.Main -> RootComponent.Child.Main(
                getComponent(parametersOf(
                    context
                ))
            )
            is Config.Details -> RootComponent.Child.Details(
                getComponent(parametersOf(
                    { navigation.pop() },
                    context
                ))
            )
        }

    @Serializable
    private sealed interface Config {

        @Serializable
        data object Main : Config

        @Serializable
        data class Details(val id: Int) : Config

    }

}