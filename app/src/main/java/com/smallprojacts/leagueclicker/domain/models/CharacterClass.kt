package com.smallprojacts.leagueclicker.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class CharacterClass(

    @SerialName("id") var id: Int? = null,
    @SerialName("legacy_id") var legacyId: Int? = null,
    @SerialName("sub_type") var subType: String? = null,
    @SerialName("created_at") var createdAt: String? = null,
    @SerialName("updated_at") var updatedAt: String? = null,
    @SerialName("class_image") var class_image: String? = null

)