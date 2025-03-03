package com.watchlist.watchlist_api.config

import com.watchlist.watchlist_api.client.OMDBClient
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

@Configuration
class OMDBHttpConfiguration {

    @Value("\${api.omdb.base-url}")
    private var baseURL: String = ""

    private fun buildClient() = OkHttpClient.Builder().build()

    private fun buildRetrofit(): Retrofit {
        val contentType = "application/json".toMediaType()
        val kotlinxConverterFactory = Json {
            ignoreUnknownKeys = true
        }
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .client(buildClient())
            .addConverterFactory(kotlinxConverterFactory.asConverterFactory(contentType))
            .build()
    }

    @Bean
    fun OMDBClient(): OMDBClient = buildRetrofit().create(OMDBClient::class.java)
}