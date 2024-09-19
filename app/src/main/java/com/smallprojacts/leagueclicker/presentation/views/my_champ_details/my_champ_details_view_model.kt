package com.smallprojacts.leagueclicker.presentation.views.my_champ_details

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smallprojacts.leagueclicker.data.api.AllMyEvents
import com.smallprojacts.leagueclicker.data.api.ApiState
import com.smallprojacts.leagueclicker.data.api.Champ
import com.smallprojacts.leagueclicker.domain.models.repositories.ChampDetailsRepository
import kotlinx.coroutines.launch

class MyChampDetailsViewModel(private val repository: ChampDetailsRepository) : ViewModel()
{
    var state by mutableStateOf(MyChampDetailsState())
        private set


    fun onDynamicEvent(event: AllMyEvents){
        val myEvent = event as AllMyEvents.MyChampDetailsStateEvent;
        myEvent.data

    }

    fun onEvent(event: MyChampDetailsEvent){
        when(event){
            is MyChampDetailsEvent.PageInit -> getDetails(event.champId)
            MyChampDetailsEvent.ClickPlay -> {}
            is MyChampDetailsEvent.ClickAbility -> updateActive(event.activeId)
        }

    }
    private  fun getDetails(champId: Int){
        viewModelScope.launch {
            state = state.copy(load = ApiState.Loading)
            val champ = repository.getMyChampDetails().find { champ -> champ.id == champId }.let { it!! }
            Log.d("MyChamp", champ.toString())
            champ.abilities.getOrNull(0)?.isActive = true;

            state = state.copy(
                indexActiveIndex = champ.abilities.getOrNull(0)?.id ?: 0,
                champ = champ,
            )
            state = state.copy(load = ApiState.Empty)
        }


    }
    private  fun updateActive(activeId : Int){
        viewModelScope.launch {

            state.champ.abilities.find { ability -> ability.id == state.indexActiveIndex }?.isActive =
                false

            state.champ.abilities.find { ability -> ability.id == activeId }?.isActive = true

            state = state.copy(
                indexActiveIndex = activeId,
                champ = state.champ,
            )


        }
    }
}

