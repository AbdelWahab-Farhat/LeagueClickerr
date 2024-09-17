package com.smallprojacts.leagueclicker.domain.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable


data class Legacy(

    @SerialName("id") var id: Int? = null,
    @SerialName("type") var type: String? = null,
    @SerialName("created_at") var createdAt: String? = null,
    @SerialName("updated_at") var updatedAt: String? = null

)