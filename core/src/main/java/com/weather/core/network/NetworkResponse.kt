package com.weather.core.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun <T> ViewModel.networkExecutor(networkBuilder: NetworkBuilder<T>.() -> Unit) {
    viewModelScope.networkOperation(networkBuilder)
}

fun <T> CoroutineScope.networkOperation(networkBuilder: NetworkBuilder<T>.() -> Unit) {
    this.launch {
        val builder = NetworkBuilder<T>().apply { networkBuilder() }
        try {
            builder.builderStartLambda?.invoke()

            val result = builder.builderApiCall?.invoke(this)!!

            builder.builderSuccess.invoke(result)


        } catch (e: Exception) {
            builder.builderErrorLambda?.invoke(this, e)
        } finally {
            builder.builderFinishLambda?.invoke()
        }
    }
}