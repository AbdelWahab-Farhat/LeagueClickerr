package com.smallprojacts.leagueclicker.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MyStats(
    @SerialName("strength") var strength: Int? = null,
    @SerialName("speed") var speed: Int? = null,
    @SerialName("intelligence") var intelligence: Int? = null,
    @SerialName("attack_damage") var attackDamage: Int? = null,
    @SerialName("ability_power") var abilityPower: Int? = null,
    @SerialName("health") var health: Int? = null
)