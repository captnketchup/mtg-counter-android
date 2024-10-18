package com.blazenterprises.mtgcounter.gamestate

data class GameState(
    var totalLifeOfPlayers: Int,
    var numberOfPlayers: Int,
    var history: List<String>
)