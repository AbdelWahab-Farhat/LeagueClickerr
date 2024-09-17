package com.smallprojacts.leagueclicker.domain.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable


data class Abilities(

    @SerialName("id") var id: Int? = null,
    @SerialName("champion_id") var championId: Int? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("description") var description: String? = null,
    @SerialName("ability_type") var abilityType: String? = null,
    @SerialName("ability_image") var abilityImage: String? = null,
    @SerialName("created_at") var createdAt: String? = null,
    @SerialName("updated_at") var updatedAt: String? = null

)