package com.watchlist.watchlist_api.service

import com.watchlist.watchlist_api.client.OMDBClient
import com.watchlist.watchlist_api.model.Midia
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class OMDBService(
    private val omdbClient: OMDBClient
) {

    @Value("\${api.omdb.apiKey}")
    private val apiKey: String = ""

    fun buscarPeloImdbId(imdbId: String) =
        omdbClient.buscarPeloImdbId(imdbId, apiKey)
            .execute()
            .body()

    suspend fun buscar(termoPesquisa: String, page: Int) =
        omdbClient.buscar(termoPesquisa, page, apiKey)
}
