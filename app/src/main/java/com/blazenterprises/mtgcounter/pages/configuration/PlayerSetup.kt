package com.blazenterprises.mtgcounter.pages.configuration

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.blazenterprises.mtgcounter.gamestate.GameState

@Composable
fun PlayerSetup(navController: NavController, gameState: GameState){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row (
          modifier = Modifier
              .fillMaxWidth()
              .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Go Back"
                )
            }
            IconButton(onClick = { navController.navigate("welcome") }) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Navigate to WelcomeScreen"
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "SET PLAYERS",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Grid of dice buttons for setting the number of players
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                for (row in 0 until 2) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.padding(bottom = 16.dp)
                    ) {
                        for (column in 1..3) {
                            val playerNumber = row * 3 + column
                            Button(
                                onClick = {
                                    gameState.numberOfPlayers = playerNumber
                                    navController.navigate("gameView")
                                },
                                modifier = Modifier
                                    .size(80.dp),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF42A5F5),
                                    contentColor = Color.White
                                )
                            ) {
                                IconButton(onClick = { navController.navigate("game") }) {
                                    Icon(
                                        imageVector = Icons.Default,
                                        contentDescription = "Navigate to WelcomeScreen"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }    }
}