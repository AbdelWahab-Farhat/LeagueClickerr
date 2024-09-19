package com.smallprojacts.leagueclicker.presentation.views.my_champ_details

import com.smallprojacts.leagueclicker.data.api.ApiState
import com.smallprojacts.leagueclicker.data.api.Champ
import com.smallprojacts.leagueclicker.domain.models.AllChamp
import com.smallprojacts.leagueclicker.domain.models.MyChamp
import com.smallprojacts.leagueclicker.domain.models.repositories.ChampItemRepository

data class MyChampDetailsState (
   override val load: ApiState = ApiState.Empty,
   val champ : MyChamp = (MyChamp()),
   override val indexActiveIndex: Int = 0
): ChampItemRepository