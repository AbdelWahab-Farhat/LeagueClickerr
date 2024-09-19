package com.smallprojacts.leagueclicker.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable

data class MyChamp(
    @SerialName("id") var id: Int? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("title") var title: String? = null,
    @SerialName("description") var description: String? = null,
    @SerialName("abilities") var abilities: ArrayList<Abilities> = arrayListOf(),
    @SerialName("stats") var stats: MyStats? = MyStats(),
    @SerialName("number_of_clicks") var numberOfClicks: Int? = null,
    @SerialName("model_3d") var model3d: String? = null,
    @SerialName("champion_image") var championImage: String? = null,





    )