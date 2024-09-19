package com.smallprojacts.leagueclicker.presentation.views.all_champ_details

import com.smallprojacts.leagueclicker.domain.models.AllChamp
import com.smallprojacts.leagueclicker.domain.models.MyChamp
import com.smallprojacts.leagueclicker.presentation.views.my_champ_details.MyChampDetailsEvent

sealed class AllChampDetailsEvent  {
    data class PageInit(val champId: Int) : AllChampDetailsEvent()
    data object ClickAdd : AllChampDetailsEvent()
    data class ClickAbility(val activeId: Int) : AllChampDetailsEvent()
}




