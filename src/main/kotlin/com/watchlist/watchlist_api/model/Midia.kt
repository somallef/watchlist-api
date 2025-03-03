package com.watchlist.watchlist_api.model

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*

@Serializable(with = Midia.MidiaSerializer::class)
sealed interface Midia {

    val titulo: String
    val tipo: String
    val ano: String
    val dataLancamento: String
    val duracao: String
    val genero: String
    val sinopse: String
    val posterUrl: String
    val avaliacoes: Collection<Avaliacao>

    @Serializable
    data class Filme @OptIn(ExperimentalSerializationApi::class) constructor(

        @JsonNames("Title")
        override val titulo: String,

        @JsonNames("Type")
        override val tipo: String = "movie",

        @JsonNames("Year")
        override val ano: String,

        @JsonNames("Released")
        override val dataLancamento: String,

        @JsonNames("Runtime")
        override val duracao: String,

        @JsonNames("Genre")
        override val genero: String,

        @JsonNames("Plot")
        override val sinopse: String,

        @JsonNames("Poster")
        override val posterUrl: String,

        @JsonNames("Ratings")
        override val avaliacoes: Collection<Avaliacao>,

        @JsonNames("Director")
        val diretor: String
    ) : Midia

    @Serializable
    data class Serie @OptIn(ExperimentalSerializationApi::class) constructor(

        @JsonNames("Title")
        override val titulo: String,

        @JsonNames("Type")
        override val tipo: String = "series",

        @JsonNames("Year")
        override val ano: String,

        @JsonNames("Released")
        override val dataLancamento: String,

        @JsonNames("Runtime")
        override val duracao: String,

        @JsonNames("Genre")
        override val genero: String,

        @JsonNames("Plot")
        override val sinopse: String,

        @JsonNames("Poster")
        override val posterUrl: String,

        @JsonNames("Ratings")
        override val avaliacoes: Collection<Avaliacao>,

        @JsonNames("totalSeasons")
        val quantidadeTemporadas: Int
    ) : Midia

    object MidiaSerializer : JsonContentPolymorphicSerializer<Midia>(Midia::class) {
        override fun selectDeserializer(element: JsonElement): DeserializationStrategy<out Midia> {
            return when (element.jsonObject["Type"]?.jsonPrimitive?.content) {
                "movie" -> Filme.serializer()
                "series" -> Serie.serializer()
                else -> throw Exception("Unknown Midia: key 'type' not found or does not matches any midia type")
            }
        }
    }
    
}

