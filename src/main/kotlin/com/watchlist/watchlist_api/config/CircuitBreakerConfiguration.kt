package com.watchlist.watchlist_api.config

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import org.springframework.context.annotation.Configuration
import java.time.Duration

@Configuration
class CircuitBreakerConfiguration {

    private fun getConfiguration() = CircuitBreakerConfig.custom()
        .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
        .slidingWindowSize(5)
        .slowCallRateThreshold(70.0f)
        .failureRateThreshold(70.0f)
        .waitDurationInOpenState(Duration.ofSeconds(5))
        .slowCallDurationThreshold(Duration.ofSeconds(3))
        .permittedNumberOfCallsInHalfOpenState(3)
        .build()

    fun getCircuitBreaker() = CircuitBreakerRegistry.of(getConfiguration())
        .circuitBreaker("circuit-breaker-omdb-service")
}