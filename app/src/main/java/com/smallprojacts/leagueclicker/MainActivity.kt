package com.smallprojacts.leagueclicker
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smallprojacts.leagueclicker.presentation.views.all_champ_details.AllChampScreen
import com.smallprojacts.leagueclicker.presentation.views.login.LoginView
import com.smallprojacts.leagueclicker.presentation.views.main_screen.MainScreen
import com.smallprojacts.leagueclicker.presentation.views.register.RegisterView
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
        startDestination = "main_screen" // Starting screen
    ) {
        composable("login_view") {
            LoginView(navController =  navController)
        }
        composable("register_view") {
            RegisterView(navController)
        }
        composable("all_champs_view") {
            AllChampScreen(navController= navController)
        }
        composable("main_screen") {
            MainScreen(navController= navController)
        }
        composable("search") {
            SearchScreen(navController= navController)
        }
        // add more screen here
    }
}