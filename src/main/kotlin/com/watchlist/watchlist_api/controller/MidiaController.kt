package com.watchlist.watchlist_api.controller

import com.watchlist.watchlist_api.model.Midia
import com.watchlist.watchlist_api.model.ResultadoPesquisa
import com.watchlist.watchlist_api.service.OMDBService
import kotlinx.coroutines.runBlocking
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Objects


@RestController
@RequestMapping(path = ["/api/watchlist/v1/midia"])
class MidiaController(
    private val omdbService: OMDBService
) {
    @GetMapping
    fun buscar(
        @RequestParam termoPesquisa: String,
        @RequestParam(defaultValue = "1") page: String
    ) = runBlocking {
        omdbService.buscar(termoPesquisa, page.toInt())
    }

    @GetMapping("/{imdbId}")
    fun buscarPeloImdbId(
        @PathVariable imdbId: String
    ): ResponseEntity<Midia> {
        val resultado = omdbService.buscarPeloImdbId(imdbId)
        return ResponseEntity.ok(resultado)
    }
}

