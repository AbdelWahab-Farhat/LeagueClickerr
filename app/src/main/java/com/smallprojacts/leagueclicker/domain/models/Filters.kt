package com.smallprojacts.leagueclicker.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Filters (
    @SerialName("regions") var regions: ArrayList<Region> = arrayListOf(),
    @SerialName("positions") var positions: ArrayList<Position> = arrayListOf(),
    @SerialName("legacies") var legaceies: ArrayList<Legacy> = arrayListOf(),
)