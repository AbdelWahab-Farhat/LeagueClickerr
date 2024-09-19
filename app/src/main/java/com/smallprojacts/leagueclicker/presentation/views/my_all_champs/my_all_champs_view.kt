package com.smallprojacts.leagueclicker.presentation.views.my_all_champs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.smallprojacts.leagueclicker.data.api.HomeApi
import com.smallprojacts.leagueclicker.domain.models.AllChamp
import com.smallprojacts.leagueclicker.presentation.components.ChampionGrid
import com.smallprojacts.leagueclicker.presentation.components.RandomChampSpotLight
import kotlinx.coroutines.launch

@Composable
fun MyChampPage(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    // Define state for the list of champions
    var champs by remember { mutableStateOf<List<AllChamp>>(emptyList()) }
    val coroutineScope = rememberCoroutineScope()

    // Fetch champions when the composable is first launched
    LaunchedEffect(Unit) {
        coroutineScope.launch {
            // Fetch the list of champions and update the state
            champs = HomeApi().getChamps()
        }
    }
    ChampionGrid(
        modifier = Modifier.padding(innerPadding).padding(horizontal = 20.dp),
        champs = champs,
        navController = navController,
        isMyChamp = true,
        header = {
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Recent Champion",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        RandomChampSpotLight(modifier = Modifier, champs = champs)

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "My Champions",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(15.dp))
    }
    )
}
