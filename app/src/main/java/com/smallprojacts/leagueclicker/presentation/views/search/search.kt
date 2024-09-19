package com.smallprojacts.leagueclicker.presentation.views.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.smallprojacts.leagueclicker.R
import com.smallprojacts.leagueclicker.presentation.components.ChampionGrid
import com.smallprojacts.leagueclicker.presentation.components.CustomChampTopBar
import com.smallprojacts.leagueclicker.presentation.components.CustomTextField

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    state: SearchState,
    onEvent: (SearchEvent) -> Unit,
) {
    LaunchedEffect(key1 = Unit) {
        onEvent(
            SearchEvent.OnChampionSearch(
                legacyUid = state.legacyUid,
                regionUid = state.regionUid,
                positionUid = state.positionUid,
                text = state.text,
            )
        )
    }
    Scaffold(
        modifier = modifier.background(
            brush = Brush.linearGradient(
                colors = listOf(Color(0xff091428), Color(0xff0A1428)),
                start = Offset(0f, 0f),
                end = Offset(0f, Float.POSITIVE_INFINITY)
            )
        ),
        containerColor = Color.Transparent,
        topBar = {
            Column(
                modifier = modifier.background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xff091428), Color(0xff0A1428)),
                        start = Offset(0f, 0f),
                        end = Offset(0f, Float.POSITIVE_INFINITY)
                    )
                ), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start
            ) {
                CustomChampTopBar(navController = navController, title = {
                    Box(
                        modifier = modifier.fillMaxWidth()
                    ) {
                        CustomTextField(
                            label = null,
                            placeholder = {
                                Text(
                                    text = "Search", color = Color.White
                                )
                            },
                            onTextChanged = { text ->
                                onEvent(SearchEvent.OnSearchChange(text))
                            },
                            suffexicon = {
                                IconButton(
                                    onClick = {
                                        onEvent(
                                            SearchEvent.OnChampionSearch(
                                                legacyUid = state.legacyUid,
                                                regionUid = state.regionUid,
                                                positionUid = state.positionUid,
                                                text = state.text,
                                            )
                                        )
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = "Search Icon",
                                        tint = Color.White,
                                        modifier = Modifier.padding(end = 8.dp)
                                    )
                                }
                            })
                    }
                }, iconButton = {
                    IconButton(onClick = {
                        onEvent(SearchEvent.FilterToggle)
                    }) {
                        Icon(
                            imageVector = if (state.isFilterEnabled) Icons.Filled.FilterAltOff else Icons.Filled.FilterAlt,
                            contentDescription = "Filter",
                            tint = Color(0xffF3F2F3)
                        )
                    }
                })
                if (state.isFilterEnabled) {
                    Text("Region", color = Color.White, modifier = Modifier.padding(start = 20.dp))
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        item {
                            Spacer(Modifier.width(20.dp))
                        }
                        state.filters?.regions?.forEach { region ->
                            item {
                                AssistChip(
                                    onClick = {
                                        onEvent(
                                            SearchEvent.OnChampionSearch(
                                                regionUid = if (state.regionUid != region.id.toString()) region.id.toString() else null,
                                                legacyUid = state.legacyUid,
                                                positionUid = state.positionUid,
                                                text = state.text,
                                            )
                                        )
                                    },
                                    colors = AssistChipDefaults.assistChipColors(
                                        containerColor = if (state.regionUid == region.id.toString()) Color(
                                            0xffC89B3C
                                        ) else Color.Transparent
                                    ),
                                    label = {
                                        Text(
                                            "${region.name}",
                                            color = Color(0xffF3F2F3)
                                        )
                                    },
                                )
                            }
                        }
                        item {
                            Spacer(Modifier.width(20.dp))
                        }
                    }
                    Text("Legacy", color = Color.White, modifier = Modifier.padding(start = 20.dp))
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        item {
                            Spacer(Modifier.width(20.dp))
                        }
                        state.filters?.legaceies?.forEach { legacy ->
                            item {
                                AssistChip(
                                    onClick = {
                                        onEvent(
                                            SearchEvent.OnChampionSearch(
                                                legacyUid = if (state.legacyUid != legacy.id.toString()) legacy.id.toString() else null,
                                                regionUid = state.regionUid,
                                                positionUid = state.positionUid,
                                                text = state.text,
                                            )
                                        )
                                    },
                                    colors = AssistChipDefaults.assistChipColors(
                                        containerColor = if (state.legacyUid == legacy.id.toString()) Color(
                                            0xffC89B3C
                                        ) else Color.Transparent
                                    ),
                                    label = {
                                        Text(
                                            "${legacy.type}",
                                            color = Color(0xffF3F2F3)
                                        )
                                    },
                                )
                            }
                        }
                        item {
                            Spacer(Modifier.width(20.dp))
                        }
                    }
                    Text(
                        "Position",
                        color = Color.White,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        item {
                            Spacer(Modifier.width(20.dp))
                        }
                        state.filters?.positions?.forEach { position ->
                            item {
                                AssistChip(
                                    onClick = {
                                        onEvent(
                                            SearchEvent.OnChampionSearch(
                                                positionUid = if (state.positionUid != position.id.toString()) position.id.toString() else null,
                                                legacyUid = state.legacyUid,
                                                regionUid = state.regionUid,
                                                text = state.text,
                                            )
                                        )
                                    },
                                    colors = AssistChipDefaults.assistChipColors(
                                        containerColor = if (state.positionUid == position.id.toString()) Color(
                                            0xffC89B3C
                                        ) else Color.Transparent
                                    ),
                                    label = {
                                        Text(
                                            "${position.name}",
                                            color = Color(0xffF3F2F3)
                                        )
                                    },
                                )
                            }
                        }
                        item {
                            Spacer(Modifier.width(20.dp))
                        }
                    }
                }
            }
        },
    ) { innerPadding ->
            ChampionGrid(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 20.dp),
                navController = navController,
                champs = state.filteredChampions,
            )
    }
}
