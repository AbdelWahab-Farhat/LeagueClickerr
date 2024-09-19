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
import com.smallprojacts.leagueclicker.data.api.SearchImpl
import com.smallprojacts.leagueclicker.presentation.views.SplashView
import com.smallprojacts.leagueclicker.presentation.views.all_champ_details.AllChampDetailsScreen
import com.smallprojacts.leagueclicker.presentation.views.all_champ_details.AllChampDetailsViewModel
import com.smallprojacts.leagueclicker.presentation.views.forgetView.ForgotView
import com.smallprojacts.leagueclicker.presentation.views.login.LoginView
import com.smallprojacts.leagueclicker.presentation.views.main_screen.MainScreen
import com.smallprojacts.leagueclicker.presentation.views.my_champ_details.MyChampDetailsViewModel
import com.smallprojacts.leagueclicker.presentation.views.my_champ_details.MyChampScreen
import com.smallprojacts.leagueclicker.presentation.views.register.RegisterView
import com.smallprojacts.leagueclicker.presentation.views.search.SearchScreen
import com.smallprojacts.leagueclicker.presentation.views.search.SearchViewModel
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
                    //"my_champ_detail_view/{}"
                    "splash_screen"
                }
                NavigationComponent(
                    navController = navController,
                    startDestination = startDestination
                )
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
            LoginView(navController = navController)
        }
        composable("register_view") {
            RegisterView(navController = navController)
        }
        composable("my_champ_detail_view/{champId}") {backStackEntry ->
            val champId =  backStackEntry.arguments?.getString("champId").toString().toInt()
            val myChampModel: MyChampDetailsViewModel =
                viewModel() { MyChampDetailsViewModel(repository = ChampDetailImpl()) }
            MyChampScreen(
                navController = navController,
                state = myChampModel.state,
                onEvent = myChampModel::onEvent,
                championId = champId ?: 0
            )
        }
        composable("forget_view") {
            ForgotView(navController = navController)
        }
        composable("all_champ_detail_view/{champId}") { backStackEntry ->
            val champId =  backStackEntry.arguments?.getString("champId").toString().toInt()
            val champModel: AllChampDetailsViewModel =
                viewModel() { AllChampDetailsViewModel(repository = ChampDetailImpl()) }
            AllChampDetailsScreen(
                navController = navController,
                state = champModel.state,
                onEvent = champModel::onEvent,
                championId = champId ?: 0
            )
        }

        composable("main_screen") {
            MainScreen(navController = navController)
        }
        composable("search") {
            val searchViewModel = viewModel() { SearchViewModel(searchRepository = SearchImpl()) }
            SearchScreen(
                navController = navController,
                state = searchViewModel.state,
                onEvent = searchViewModel::onEvent
            )
        }
        composable("splash_screen") {
            SplashView(navController = navController)
        }
        // add more screen here
    }
}
