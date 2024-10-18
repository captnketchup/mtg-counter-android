package com.blazenterprises.mtgcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.blazenterprises.mtgcounter.gamestate.GameState
import com.blazenterprises.mtgcounter.pages.SettingsScreen
import com.blazenterprises.mtgcounter.pages.configuration.LifeSetupPage
import com.blazenterprises.mtgcounter.pages.configuration.PlayerSetup
import com.blazenterprises.mtgcounter.pages.game.GameView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val gameState = GameState(0, 0, emptyList(), emptyList())
    NavHost(navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("startGame") { LifeSetupPage(navController, gameState) }
        composable("settings") { SettingsScreen() }
        composable("playerSetup") { PlayerSetup(navController, gameState) }
        composable("game") { GameView(navController, gameState) }
    }
}

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.mennogitar),
            contentDescription = "Logo",
            modifier = Modifier
                .size(256.dp)
                .padding(bottom = 32.dp)
        )

        Button(
            onClick = { navController.navigate("startGame") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF42A5F5)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(text = "Start Game")
        }

        Button(
            onClick = { navController.navigate("settings") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF42A5F5)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Settings")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(navController = rememberNavController())
}