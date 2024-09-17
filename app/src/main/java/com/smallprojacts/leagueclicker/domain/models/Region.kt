package com.smallprojacts.leagueclicker.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class Region(

    @SerialName("id") var id: Int? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("description") var description: String? = null,
    @SerialName("created_at") var createdAt: String? = null,
    @SerialName("updated_at") var updatedAt: String? = null

)