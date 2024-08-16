package com.yourcompany.bullseye

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yourcompany.bullseye.screens.AboutScreen
import com.yourcompany.bullseye.screens.GameScreen
import com.yourcompany.bullseye.ui.theme.BullseyeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BullseyeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    MainScreen()

                }
            }
        }
    }
}

@Composable
fun MainScreen(
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "gamescreen") {
        composable("gamescreen") {
            GameScreen(
                onNavigateToAbout = { navController.navigate("about") }
            )
        }

        composable("about") {
            AboutScreen(onNavigateBack = { navController.popBackStack() })
        }
    }

}
