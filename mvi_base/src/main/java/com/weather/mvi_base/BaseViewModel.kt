package com.weather.mvi_base

import kotlinx.coroutines.flow.StateFlow

interface BaseViewModel<I : BaseIntent, S : BaseState> {

    val state: StateFlow<S>
    fun processIntent(intent: I)
}