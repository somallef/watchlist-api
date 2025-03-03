package com.watchlist.watchlist_api.client

import com.watchlist.watchlist_api.model.Midia
import com.watchlist.watchlist_api.model.ResultadoPesquisa
import org.springframework.stereotype.Service
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

@Service
interface OMDBClient {

    @GET("https://www.omdbapi.com/")
    suspend fun buscar(@Query("s") termoPesquisa: String,
                   @Query("page") page: Int,
                   @Query("apiKey") apiKey: String
                   ): ResultadoPesquisa
    @GET("https://www.omdbapi.com/")
    fun buscarPeloImdbId(@Query("i") imdbId: String,
                   @Query("apiKey") apiKey: String
                   ): Call<Midia>

}