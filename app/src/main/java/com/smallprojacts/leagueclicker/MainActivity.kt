package com.smallprojacts.leagueclicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smallprojacts.leagueclicker.presentation.views.LoginView
import com.smallprojacts.leagueclicker.presentation.views.search.SearchScreen
import com.smallprojacts.leagueclicker.ui.theme.LeagueClickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeagueClickerTheme {
                val navController = rememberNavController()
                NavigationComponent(navController)
            }
        }
    }
}


@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login_view" // Starting screen
    ) {
        composable("login_view") {
            SearchScreen(navController = navController)
        }
        // add more screen here
    }
}

