package com.weather.mvi_base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

abstract class BaseActivity<
        I : BaseIntent,
        S : BaseState,
        VM : BaseViewModel<I, S>,
        > : ComponentActivity() {

    protected abstract val vm: VM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        collectState()
    }

    private fun collectState() {
        lifecycleScope.launch {
            vm.state.collect { state ->
                renderState(state)
            }
        }
    }

    abstract fun renderState(state: S)
}