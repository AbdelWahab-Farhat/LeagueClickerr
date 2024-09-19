package com.smallprojacts.leagueclicker.presentation.views.all_champ_details

import com.smallprojacts.leagueclicker.data.api.ApiState
import com.smallprojacts.leagueclicker.domain.models.AllChamp
import com.smallprojacts.leagueclicker.domain.models.repositories.ChampItemRepository

data class AllChampDetailsState(
    override val load: ApiState = ApiState.Empty,
     val champ: AllChamp  =AllChamp(),

    override val indexActiveIndex: Int = 0


): ChampItemRepository