package com.smallprojacts.leagueclicker.presentation.views.all_champs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.smallprojacts.leagueclicker.presentation.components.ChampionGrid
import com.smallprojacts.leagueclicker.presentation.components.CustomTextField
import com.smallprojacts.leagueclicker.presentation.components.RuneterraRegions

@Composable
fun AllChampView(
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
    ChampionGrid(
        modifier = Modifier
            .padding(innerPadding)
            .padding(horizontal = 20.dp),
        champs = stats,
        header = {
            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = modifier.clickable {
                    navController.clearBackStack("search")
                    navController.navigate("search")
                }
            ) {
                CustomTextField(
                    isEnabled = false,
                    label = null,
                    placeholder = {
                        Text(
                            text = "Search",
                            color = Color(0xffF3F2F3)
                        )
                    },
                    suffexicon =
                    {
                        Row {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search Icon",
                                tint = Color(0xffF3F2F3),
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "Search Icon",
                                tint = Color(0xffF3F2F3),
                                modifier = Modifier.padding(end = 8.dp)
                            )
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Runeterra",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xffF3F2F3)
            )

            RuneterraRegions(modifier)

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Champions",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xffF3F2F3)
            )

            Spacer(modifier = Modifier.height(15.dp))
        }
    )
}
