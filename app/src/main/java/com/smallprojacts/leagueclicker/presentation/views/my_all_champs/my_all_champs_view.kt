package com.smallprojacts.leagueclicker.presentation.views.my_all_champs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.smallprojacts.leagueclicker.presentation.components.ChampionGrid
import com.smallprojacts.leagueclicker.presentation.components.RandomChampSpotLight

@Composable
fun MyAllChampView(modifier: Modifier = Modifier, navController: NavHostController, innerPadding: PaddingValues) {
    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(innerPadding)
            .padding(20.dp, 0.dp)
    ) {
        val stats = mapOf(
            "Strength" to 1,
            "Intelligence" to 5,
            "Speed" to 3,
            "Health" to 2,
            "Attack Damage" to 4,
            "safas" to 1,
            ";kga" to 1,
            "p9ipwt" to 1,
            "gkasg;" to 1,
            "ask" to 1,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Recent Champion",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        RandomChampSpotLight(modifier)

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "My Champions",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(15.dp))

        ChampionGrid(champs =  stats)
    }
}
