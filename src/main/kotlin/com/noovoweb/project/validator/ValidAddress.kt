package com.noovoweb.project.validator

import com.noovoweb.validator.CustomValidator

/**
 * Meta-annotation for validating addresses using Google Geocoding API.
 * 
 * This annotation validates that a physical address actually exists by performing
 * a real geocoding API call. It uses the ValidationContext's IO dispatcher for
 * non-blocking network operations.
 * 
 * Example:
 * ```kotlin
 * @Validated
 * data class ShippingRequest(
 *     @ValidAddress
 *     val address: String?
 * )
 * ```
 * 
 * The validator will:
 * 1. Use context.dispatcher (Dispatchers.IO) for the API call
 * 2. Call Google Geocoding API to verify the address exists
 * 3. Return false if the address cannot be geocoded
 * 4. Handle errors gracefully (fail open on API errors)
 */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
@CustomValidator(
    validator = "com.noovoweb.project.validator.AddressValidators::validateAddressExists",
    message = "address.not_found"
)
annotation class ValidAddress
