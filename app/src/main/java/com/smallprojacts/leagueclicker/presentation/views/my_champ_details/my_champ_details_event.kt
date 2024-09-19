package com.smallprojacts.leagueclicker.presentation.views.my_champ_details

sealed class MyChampDetailsEvent {
    data class PageInit(val champId: Int) : MyChampDetailsEvent()
    data object ClickPlay : MyChampDetailsEvent()
    data class ClickAbility(val activeId: Int) : MyChampDetailsEvent()
}