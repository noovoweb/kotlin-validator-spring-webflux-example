package com.noovoweb.project.validator

import com.noovoweb.validator.ValidationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

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
        return withContext(Dispatchers.IO){
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
                val isValid = response.isNotEmpty()
                
                // If invalid, throw ValidationException with localized message
                if (!isValid) {
                    val message = context.messageProvider.getMessage(
                        "address.not_found",
                        null,
                        context.locale
                    )
                    throw com.noovoweb.validator.ValidationException(
                        mapOf("fullAddress" to listOf(message))
                    )
                }
                
                true
                
            } catch (e: com.noovoweb.validator.ValidationException) {
                // Re-throw validation exception
                throw e
            } catch (e: Exception) {
                // Fail open: On API error, allow the address
                // This prevents validation from breaking when API is down
                // For stricter validation, return false here (fail closed)
                println("Address validation API error: ${e.message}")
                true
            }
        }
    }
    
    /**
     * Alternative implementation using Google Geocoding API (requires API key).
     * Commented out for reference.
     */
    /*
    private val googleWebClient = WebClient.builder()
        .baseUrl("https://maps.googleapis.com/maps/api/geocode")
        .build()
    
    suspend fun validateAddressExistsGoogle(
        value: String?,
        context: ValidationContext,
        apiKey: String
    ): Boolean {
        if (value.isNullOrBlank()) return true
        
        return withContext(context.dispatcher) {
            try {
                val response = googleWebClient.get()
                    .uri { uriBuilder ->
                        uriBuilder
                            .path("/json")
                            .queryParam("address", value)
                            .queryParam("key", apiKey)
                            .build()
                    }
                    .retrieve()
                    .awaitBody<Map<String, Any>>()
                
                val results = response["results"] as? List<*>
                !results.isNullOrEmpty()
                
            } catch (e: Exception) {
                println("Google Geocoding API error: ${e.message}")
                true  // Fail open
            }
        }
    }
    */
}
