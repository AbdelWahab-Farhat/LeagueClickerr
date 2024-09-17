package com.smallprojacts.leagueclicker.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AllChamp(
    @SerialName("id") var id: Int? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("title") var title: String? = null,
    @SerialName("character_class_id") var characterClassId: Int? = null,
    @SerialName("legacy_id") var legacyId: Int? = null,
    @SerialName("position_id") var positionId: Int? = null,
    @SerialName("region_id") var regionId: Int? = null,
    @SerialName("pick_rate") var pickRate: Double? = null,
    @SerialName("win_rate") var winRate: Double? = null,
    @SerialName("ban_rate") var banRate: Double? = null,
    @SerialName("champion_image") var championImage: String? = null,
    @SerialName("created_at") var createdAt: String? = null,
    @SerialName("updated_at") var updatedAt: String? = null,
    @SerialName("position") var position: Position? = Position(),
    @SerialName("legacy") var legacy: Legacy? = Legacy(),
    @SerialName("character_class") var characterClass: CharacterClass? = CharacterClass(),
    @SerialName("abilities") var abilities: ArrayList<Abilities> = arrayListOf(),
    @SerialName("stats") var stats: Stats? = Stats(),
    @SerialName("region") var region: Region? = Region()

)










