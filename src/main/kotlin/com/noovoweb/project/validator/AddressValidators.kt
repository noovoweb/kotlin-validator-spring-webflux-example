package com.noovoweb.project.validator

import com.noovoweb.validator.CustomValidator
import com.noovoweb.validator.ValidationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
@CustomValidator(
    validator = "com.noovoweb.project.validator.AddressValidators::validateAddressExists",
    message = "address.not_found"
)
annotation class ValidAddress

/**
 * Validators for address validation using external geocoding APIs.
 * 
 * This demonstrates how to:
 * - Use ValidationContext.dispatcher for IO operations
 * - Make HTTP API calls within validators
 * - Handle network errors gracefully
 * - Implement "fail open" vs "fail closed" patterns
 */
object AddressValidators {
    
    // WebClient for making HTTP requests (non-blocking)
    private val webClient = WebClient.builder()
        .baseUrl("https://nominatim.openstreetmap.org")
        .defaultHeader("User-Agent", "KotlinValidator/1.0")
        .build()
    
    /**
     * Validates that a physical address exists by calling a geocoding API.
     * 
     * Uses OpenStreetMap's Nominatim API (free, no API key required).
     * For production, consider Google Geocoding API or similar paid services.
     * 
     * @param value The address string to validate
     * @param context ValidationContext containing dispatcher, locale, etc.
     * @return true if address exists or on API error (fail open), false if address not found
     */
    suspend fun validateAddressExists(
        value: String?,
        context: ValidationContext
    ): Boolean {
        // Null or empty is valid (use @Required for null checking)
        if (value.isNullOrBlank()) return true

        // Use the dispatcher from context for IO operations
        return withContext(Dispatchers.IO) {
            try {
                // Call OpenStreetMap Nominatim geocoding API
                val response = webClient.get()
                    .uri { uriBuilder ->
                        uriBuilder
                            .path("/search")
                            .queryParam("q", value)
                            .queryParam("format", "json")
                            .queryParam("limit", "1")
                            .build()
                    }
                    .retrieve()
                    .awaitBody<List<Map<String, Any>>>()

                // Address is valid if we get at least one result
                response.isNotEmpty()

            } catch (e: Exception) {
                // Fail open: On API error, allow the address
                // This prevents validation from breaking when API is down
                // For stricter validation, return false here (fail closed)
                println("Address validation API error: ${e.message}")
                true
            }
        }
    }

}
