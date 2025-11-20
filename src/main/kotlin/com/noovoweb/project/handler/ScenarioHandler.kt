package com.noovoweb.project.handler

import com.noovoweb.project.request.scenario.AddressValidationRequest
import com.noovoweb.project.request.scenario.OrderRequest
import com.noovoweb.validator.spring.validate

import com.noovoweb.project.request.scenario.RegisterRequest
import com.noovoweb.project.request.scenario.RegisterRequestValidator
import com.noovoweb.project.request.scenario.TwoLevelsRequest
import com.noovoweb.project.request.scenario.TwoLevelsRequestValidator
import com.noovoweb.project.request.scenario.ProductArrayRequest
import com.noovoweb.project.request.scenario.ProductArrayRequestValidator
import com.noovoweb.project.request.scenario.ShippingRequest
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.spring.ValidationContextProvider
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class ScenarioHandler(
    private val contextProvider: ValidationContextProvider
) {

    /**
     * Simulates a complete user registration form validation.
     * Tests multiple validators including:
     * - Email format validation
     * - Password strength requirements (min length, uppercase, lowercase, number)
     * - Password confirmation matching
     * - Name validation (required, alpha only, length constraints)
     * - Age validation (min/max range)
     * - Phone number format validation
     * - Terms acceptance validation
     */
    suspend fun register(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<RegisterRequest>()
        val cleaned = payload.copy(phoneNumber = payload.phoneNumber?.trim())
        RegisterRequestValidator().validate(cleaned, request, contextProvider.getBase())

        val responseData = mapOf(
            "email" to payload.email,
            "firstName" to payload.firstName,
            "lastName" to payload.lastName,
            "age" to payload.age,
            "phoneNumber" to cleaned.phoneNumber
        )

        return ServerResponse.ok().bodyValueAndAwait(
            DataResponse(
                data = responseData,
                message = "Registration successful! Welcome ${payload.firstName} ${payload.lastName}"
            )
        )
    }

    /**
     * Validates a two-level nested payload structure.
     * For demonstration, it simply validates and echoes back
     * the order ID and customer city from the nested structure.
     */
    suspend fun nestedTwoLevels(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<TwoLevelsRequest>()
        payload.validate(request, contextProvider.getBase())

        val summary = mapOf(
            "orderId" to payload.order.id,
            "customerCity" to payload.customer.address.city
        )

        return ServerResponse.ok().bodyValueAndAwait(
            DataResponse(
                data = summary,
                message = "Nested two-levels payload validated successfully"
            )
        )
    }

    /**
     * Validates an array of products.
     * Tests collections and nested objects validators including:
     * - Array must contain at least 1 product
     * - Each product must have valid name, description, price, quantity, category
     * - Product names must be 3-100 characters
     * - Descriptions must be 10-500 characters
     * - Price must be between 0.01 and 1,000,000
     * - Quantity must be >= 0
     * - Category must be 3-50 characters
     * - SKU must match pattern (optional field)
     */
    suspend fun productsArray(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<ProductArrayRequest>()
        // @Valid(each = true) on products field automatically validates each Product in the array
        payload.validate(request, contextProvider.getBase())

        val totalValue = payload.products?.sumOf { (it.price ?: 0.0) * (it.quantity ?: 0) } ?: 0.0
        val productCount = payload.products?.size ?: 0

        val summary = mapOf(
            "productCount" to productCount,
            "totalInventoryValue" to totalValue,
            "products" to payload.products?.map {
                mapOf(
                    "name" to it.name,
                    "category" to it.category,
                    "price" to it.price,
                    "quantity" to it.quantity
                )
            }
        )

        return ServerResponse.ok().bodyValueAndAwait(
            DataResponse(
                data = summary,
                message = "Products array validated successfully"
            )
        )
    }

    /**
     * Validates shipping address using geocoding API.
     * 
     * This demonstrates:
     * - Custom validator making external API calls
     * - Using ValidationContext.dispatcher for IO operations
     * - Address validation via OpenStreetMap Nominatim API
     */
    suspend fun validateShipping(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<ShippingRequest>()
        payload.validate(request, contextProvider.getBase())
        
        return ServerResponse.ok().bodyValueAndAwait(
            DataResponse(
                data = payload,
                message = "Shipping address validated successfully"
            )
        )
    }

    /**
     * Validates a full address string using geocoding API.
     */
    suspend fun validateAddress(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<AddressValidationRequest>()
        payload.validate(request, contextProvider.getBase())
        
        return ServerResponse.ok().bodyValueAndAwait(
            DataResponse(
                data = payload,
                message = "Address validated successfully"
            )
        )
    }

    /**
     * Validates an e-commerce order with nested shipping address.
     */
    suspend fun validateOrder(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<OrderRequest>()
        payload.validate(request, contextProvider.getBase())
        
        val total = (payload.quantity ?: 0) * (payload.pricePerUnit ?: 0.0)
        
        val responseData = mapOf(
            "productName" to payload.productName,
            "quantity" to payload.quantity,
            "pricePerUnit" to payload.pricePerUnit,
            "totalPrice" to total,
            "shippingTo" to mapOf(
                "addressLine1" to payload.shippingAddress?.addressLine1,
                "city" to payload.shippingAddress?.city,
                "country" to payload.shippingAddress?.country
            )
        )
        
        return ServerResponse.ok().bodyValueAndAwait(
            DataResponse(
                data = responseData,
                message = "Order validated successfully"
            )
        )
    }

}
