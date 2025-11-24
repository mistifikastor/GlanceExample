package com.example.glanceexample.glance

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

object PriceDataRepo {
    var ticker = "GOOGL"
    private var previousPrice = 100f
    var change = 0

    private var _currentPrice = MutableStateFlow(100f)
    val currentPrice: StateFlow<Float> get() = _currentPrice

    fun update() {
        previousPrice = currentPrice.value
        _currentPrice.value = Random.nextInt(20, 35) + Random.nextFloat()
        change = if (previousPrice != 0f) {
            ((_currentPrice.value - previousPrice) / previousPrice * 100).toInt()
        } else {
            0
        }
    }
}