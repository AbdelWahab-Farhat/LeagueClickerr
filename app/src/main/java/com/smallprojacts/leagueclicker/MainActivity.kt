package com.smallprojacts.leagueclicker
import com.smallprojacts.leagueclicker.presentation.views.SplashView
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smallprojacts.leagueclicker.presentation.views.login.LoginView
import com.smallprojacts.leagueclicker.presentation.views.register.RegisterView
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
        startDestination = "splash_view" // Starting screen
    ) {
        composable("login_view") {
            LoginView(navController =  navController)
        }
        composable("register_view") {
            RegisterView(navController)
        }
        composable("splash_view") {
            SplashView(navController)
        }
        // add more screen here
    }
}