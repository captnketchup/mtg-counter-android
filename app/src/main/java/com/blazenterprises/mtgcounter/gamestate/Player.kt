package com.blazenterprises.mtgcounter.gamestate

data class Player(
    var life: Int,
    var color: String,
    var counters: List<Counter>
)