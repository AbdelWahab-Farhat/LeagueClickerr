package com.smallprojacts.leagueclicker.domain.models.repositories

import com.smallprojacts.leagueclicker.data.api.ApiState
import com.smallprojacts.leagueclicker.domain.models.MyChamp

interface ChampItemRepository {
    val load: ApiState;
    val indexActiveIndex: Int
}