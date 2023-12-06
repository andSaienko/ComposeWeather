package com.weather.mvi_base

import kotlinx.coroutines.flow.StateFlow

interface BaseViewModel<I : BaseIntent, A : BaseAction, S : BaseState> {

    val viewState: StateFlow<S>
    fun handleIntent(intent: I): A
    fun handleAction(action: A)
}