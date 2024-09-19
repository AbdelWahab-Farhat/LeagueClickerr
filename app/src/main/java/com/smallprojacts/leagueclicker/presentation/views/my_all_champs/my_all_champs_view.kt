package com.smallprojacts.leagueclicker.presentation.views.my_all_champs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun MyChampPage(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    innerPadding: PaddingValues
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
//    ChampionGrid(
//        modifier = Modifier.padding(innerPadding).padding(horizontal = 20.dp),
//        champs = stats, header = {
//        Spacer(modifier = Modifier.height(20.dp))
//
//        Text(
//            text = "Recent Champion",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.White
//        )
//
//        RandomChampSpotLight(modifier)
//
//        Spacer(modifier = Modifier.height(30.dp))
//
//        Text(
//            text = "My Champions",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.White
//        )
//
//        Spacer(modifier = Modifier.height(15.dp))
//    }
//    )
}
