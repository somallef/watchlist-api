package com.watchlist.watchlist_api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Avaliacao(
    @SerialName("Source")
    val origem: String,

    @SerialName("Value")
    val nota: String
)