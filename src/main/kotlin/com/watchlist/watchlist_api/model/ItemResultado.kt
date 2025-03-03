package com.watchlist.watchlist_api.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class ItemResultado @OptIn(ExperimentalSerializationApi::class) constructor(
    @JsonNames("Title")
    val titulo: String,

    @JsonNames("Year")
    val ano: String,

    @JsonNames("imdbID")
    val imdbId: String,

    @JsonNames("Type")
    val tipo: String,

    @JsonNames("Poster")
    val posterUrl: String
)