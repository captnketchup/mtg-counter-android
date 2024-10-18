package com.blazenterprises.mtgcounter.gamestate

import androidx.compose.ui.graphics.Color

data class Player(
    var life: Int,
    var color: Color,
    var counters: List<Counter>
)