package com.smallprojacts.leagueclicker.presentation.views.all_champ_details

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smallprojacts.leagueclicker.data.api.ApiState
import com.smallprojacts.leagueclicker.domain.models.repositories.ChampDetailsRepository
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class AllChampDetailsViewModel(private val repository: ChampDetailsRepository) : ViewModel() {

    var state by mutableStateOf(AllChampDetailsState())
        private set

    fun onEvent(event: AllChampDetailsEvent) {
        when (event) {
            is AllChampDetailsEvent.PageInit -> getDetails(event.champId)
            AllChampDetailsEvent.ClickAdd -> addchamp()
            is AllChampDetailsEvent.ClickAbility -> updateActive(event.activeId)
        }
    }


    private fun getDetails(champId: Int) {
        viewModelScope.launch {
            state = state.copy(load = ApiState.Loading)
            val champ = repository.getChampDetails(champId)
            Log.d("viewmodel", "getDetails: $champ")
            champ.abilities.getOrNull(0)?.isActive = true;


            state = state.copy(
                indexActiveIndex = champ.abilities.getOrNull(0)?.id ?: 0,
                champ = champ

            )
            state = state.copy(load = ApiState.Empty)
        }
    }

    private fun updateActive(activeId: Int) {
        viewModelScope.launch {
//            state.champ.abilities.getOrNull(state.indexActiveIndex)?.isActive = false

            state.champ.abilities.find { ability -> ability.id == state.indexActiveIndex }?.isActive =
                false

            //   state.champ.abilities.getOrNull(activeId)?.isActive = true
            state.champ.abilities.find { ability -> ability.id == activeId }?.isActive = true

            state = state.copy(
                indexActiveIndex = activeId,
                champ = state.champ,
            )


        }
    }

    private fun addchamp() {
        viewModelScope.launch {
            repository.addchamp(state.champ.id ?: 0 )
        }
    }

}