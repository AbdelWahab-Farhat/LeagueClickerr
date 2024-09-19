package com.smallprojacts.leagueclicker

import TokenManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smallprojacts.leagueclicker.data.api.ChampDetailImpl
import com.smallprojacts.leagueclicker.presentation.views.all_champ_details.AllChampDetailsScreen
import com.smallprojacts.leagueclicker.presentation.views.all_champ_details.AllChampDetailsViewModel
import com.smallprojacts.leagueclicker.presentation.views.login.LoginView
import com.smallprojacts.leagueclicker.presentation.views.main_screen.MainScreen
import com.smallprojacts.leagueclicker.presentation.views.my_champ_details.MyChampDetailsViewModel
import com.smallprojacts.leagueclicker.presentation.views.my_champ_details.MyChampScreen
import com.smallprojacts.leagueclicker.presentation.views.register.RegisterView
import com.smallprojacts.leagueclicker.presentation.views.search.SearchScreen
import com.smallprojacts.leagueclicker.ui.theme.LeagueClickerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TokenManager.init(this)
        enableEdgeToEdge()
        setContent {
            LeagueClickerTheme {
                val navController = rememberNavController()
                val startDestination = if (TokenManager.getToken() != null) {
                    "main_screen"
                } else {
                    "my_champ_detail_view"
                }
                NavigationComponent(navController = navController, startDestination = startDestination)
            }
        }
    }
}


@Composable
fun NavigationComponent(navController: NavHostController, startDestination: String) {
    NavHost(
        navController = navController,
        startDestination = startDestination // Starting screen based on token availability
    ) {
        composable("login_view") {
            LoginView(navController =  navController)
        }
        composable("register_view") {
            RegisterView(navController = navController)
        }
        composable("all_champ_detail_view") {
            val champModel: AllChampDetailsViewModel = viewModel(){AllChampDetailsViewModel(repository = ChampDetailImpl())}
            AllChampDetailsScreen(navController= navController, state = champModel.state, onEvent = champModel::onEvent, championId = 1)
        }
        composable("my_champ_detail_view") {

            val myChampModel: MyChampDetailsViewModel = viewModel(){MyChampDetailsViewModel(repository = ChampDetailImpl())}
            MyChampScreen(navController= navController, state = myChampModel.state, onEvent = myChampModel::onEvent, championId = 1)
        }
        composable("main_screen") {
            MainScreen(navController= navController)
        }
        composable("search") {
            SearchScreen(navController = navController)
        }
        // add more screen here
    }
}