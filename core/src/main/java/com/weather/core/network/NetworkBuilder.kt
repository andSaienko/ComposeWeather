package com.weather.core.network

import kotlinx.coroutines.CoroutineScope

class NetworkBuilder<T> {
    internal var builderApiCall: (suspend CoroutineScope.() -> T)? = null
    internal var builderStartLambda: (() -> Unit)? = null
    internal var builderFinishLambda: (() -> Unit)? = null
    internal var builderSuccess: ((result: T) -> Unit) = {}
    internal var builderErrorLambda: (suspend CoroutineScope.(Exception) -> Unit)? = null
}

fun <T> NetworkBuilder<T>.execute(execution: suspend CoroutineScope.() -> T) {
    this.builderApiCall = execution
}

fun <T> NetworkBuilder<T>.error(error: suspend CoroutineScope.(Exception) -> Unit) {
    this.builderErrorLambda = error
}

fun <T> NetworkBuilder<T>.success(success: (T) -> Unit) {
    this.builderSuccess = success
}