package com.smallprojacts.leagueclicker.domain.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable


data class Stats(
    @SerialName("id") var id: Int? = null,
    @SerialName("champion_id") var championId: Int? = null,
    @SerialName("ad") var ad: Int? = null,
    @SerialName("ap") var ap: Int? = null,
    @SerialName("armor") var armor: Int? = null,
    @SerialName("mr") var mr: Int? = null,
    @SerialName("hp") var hp: Int? = null,
    @SerialName("health_regen") var healthRegen: Double? = null,
    @SerialName("resource_regen") var resourceRegen: Int? = null,
    @SerialName("movement_speed") var movementSpeed: Int? = null,
    @SerialName("attack_range") var attackRange: String? = null,
    @SerialName("mana") var mana: Int? = null,
    @SerialName("mana_regen") var manaRegen: Int? = null,
    @SerialName("attack_speed") var attackSpeed: Double? = null,
    @SerialName("crit_damage") var critDamage: Int? = null,
    @SerialName("energy") var energy: Int? = null,
    @SerialName("energy_regen") var energyRegen: Double? = null,
    @SerialName("created_at") var createdAt: String? = null,
    @SerialName("updated_at") var updatedAt: String? = null

)