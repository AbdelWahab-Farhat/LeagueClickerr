package com.smallprojacts.leagueclicker.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.smallprojacts.leagueclicker.domain.models.AllChamp

@Composable
fun ChampionGrid(
    modifier: Modifier = Modifier,
    champs: List<AllChamp>,
    itemsPerRow: Int = 3,
    navController: NavController,
    isMyChamp: Boolean = false,
    header: @Composable ColumnScope.() -> Unit = {},
) {
    val statList = champs.toList()
    LazyVerticalGrid(
        columns = GridCells.Fixed(itemsPerRow),
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        // Display the header if any
        item(span = { GridItemSpan(itemsPerRow) }) {
            Column {
                header()
            }
        }

        // Render each champion card
        items(champs) { champ ->
            ChampionCard(champ = champ, navController = navController, isMyChamp = isMyChamp)
        }
    }
}

@Composable
fun ChampionCard(
    modifier: Modifier = Modifier,
    champ: AllChamp,
    navController: NavController,
    isMyChamp: Boolean
) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .width(150.dp)
            .clickable {
                if (isMyChamp)
                    navController.navigate("my_champ_detail_view/${champ.id}")
                else
                    navController.navigate("all_champ_detail_view/${champ.id}")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,

            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Champion Image
            ChampImage(champ)

            // Champion Name
            Text(
                text = champ.name ?: "Unknown Champ", // Make name dynamic
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )

            // Champion Title
            Text(
                text = champ.title ?: "Unknown Title", // Make title dynamic
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
            )
        }
    }
}

@Composable
fun ChampImage(champ: AllChamp) {
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(champ.championImage)
                .crossfade(true) // Optional: Enable fade-in animation
//                .placeholder(R.drawable.poro) // Optional: Placeholder image
//                .error(R.drawable.jinx) // Optional: Error image in case loading fails
                .build()
        ),
        contentDescription = "${champ.name}'s image",
        modifier = Modifier
            .height(130.dp)
            .clip(shape = RoundedCornerShape(10))
            .border(
                border = BorderStroke(2.dp, Color.Black),
                shape = RoundedCornerShape(10)
            ),
        contentScale = ContentScale.Crop
    )
}