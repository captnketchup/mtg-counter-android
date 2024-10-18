package com.blazenterprises.mtgcounter.pages.game

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.blazenterprises.mtgcounter.gamestate.GameState

@Composable
fun GameView(navController: NavController, gameState: GameState) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Adjust the number of columns as needed
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly
    ) {
        items(gameState.players.take(gameState.numberOfPlayers)) { player ->
            PlayerLifeCard(player.life)
        }
    }
}

@Composable
fun PlayerLifeCard(life: Int) {
    Card(
        modifier = Modifier.fillMaxSize(0.4f), // Adjust the size as needed
        content = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Life: $life",
                    textAlign = TextAlign.Center
                )
            }
        }
    )
}