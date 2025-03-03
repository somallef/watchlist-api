package com.watchlist.watchlist_api.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class ResultadoPesquisa @OptIn(ExperimentalSerializationApi::class) constructor(
    @JsonNames("Search")
    val itens: Collection<ItemResultado>,

    @JsonNames("totalResults")
    val quantidadeItens: Long,

    @JsonNames("Response")
    val response: Boolean
)