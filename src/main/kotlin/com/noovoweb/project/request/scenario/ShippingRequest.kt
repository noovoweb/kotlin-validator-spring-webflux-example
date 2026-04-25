package com.noovoweb.project.request.scenario

import com.noovoweb.project.validator.ValidAddress
import com.noovoweb.validator.*

/**
 * Example request for shipping/delivery with address validation.
 * 
 * This demonstrates:
 * - Using custom meta-annotation @ValidAddress
 * - Combining with built-in validators
 * - Real-world use case for geocoding validation
 */
@Validated
data class ShippingRequest(
    @Required
    @MinLength(3)
    val recipientName: String?,
    
    @Required
    @ValidAddress  // ✨ Validates address exists via geocoding API
    val streetAddress: String?,
    
    @Required
    @MinLength(2)
    val city: String?,
    
    @Required
    @MinLength(2)
    val state: String?,
    
    @Required
    @Pattern("^[0-9]{5}(-[0-9]{4})?$")  // US ZIP code format
    val zipCode: String?,
    
    @Required
    @Email
    val email: String?,
    
    @Required
    @Pattern("^\\+?[1-9]\\d{1,14}$")  // E.164 phone format
    val phone: String?,
    
    @MinLength(10)
    val deliveryInstructions: String?
)

/**
 * Full address request that validates complete address string.
 */
@Validated
data class AddressValidationRequest(
    @Required
    @ValidAddress  // ✨ Validates the complete address via API
    val fullAddress: String?
)

/**
 * E-commerce order with validated shipping address.
 */
@Validated
data class OrderRequest(
    @Required
    @MinLength(3)
    val productName: String?,
    
    @Required
    @Positive
    val quantity: Int?,
    
    @Required
    @Positive
    val pricePerUnit: Double?,
    
    // Nested object with address validation
    @Valid
    val shippingAddress: ShippingAddress?
)

@Validated
data class ShippingAddress(
    @Required
    @ValidAddress  // ✨ Geocodes the full address
    val addressLine1: String?,
    
    val addressLine2: String?,
    
    @Required
    @MinLength(2)
    val city: String?,
    
    @Required
    @MinLength(2)
    val country: String?
)
