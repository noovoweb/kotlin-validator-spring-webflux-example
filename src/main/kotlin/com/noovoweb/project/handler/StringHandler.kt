package com.noovoweb.project.handler

import com.noovoweb.validator.spring.validate
import com.noovoweb.validator.spring.validateMono

import com.noovoweb.project.request.string.*
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.spring.ValidationContextProvider
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class StringHandler(
    private val contextProvider: ValidationContextProvider
)  {

    // ========================================
    // NEW SIMPLIFIED API EXAMPLES  
    // ========================================
    // Compare these with the original API below!

    /**
     * SIMPLIFIED: Just call payload.validate(request, context)
     * No need to instantiate validator manually!
     */
    suspend fun requiredSimplified(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<RequiredRequest>()
        payload.validate(request, contextProvider.getBase())  // Auto-discovers validator!
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful (simplified)"))
    }

    /**
     * ULTRA SIMPLIFIED: Just payload.validate()
     * Uses default context - perfect for simple cases!
     */
    suspend fun emailUltraSimplified(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<EmailRequest>()
        payload.validate()  // That's it!
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful (ultra-simplified)"))
    }

    // ========================================
    // ORIGINAL API (Still Supported)
    // ========================================

    suspend fun required(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<RequiredRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun email(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<EmailRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun url(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<UrlRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun uuid(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<UuidRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun length(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<LengthRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun minLength(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<MinLengthRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun maxLength(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<MaxLengthRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun pattern(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<PatternRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun alpha(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<AlphaRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun alphanumeric(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<AlphanumericRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun ascii(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<AsciiRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun lowercase(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<LowercaseRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun uppercase(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<UppercaseRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun startsWith(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<StartsWithRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun endsWith(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<EndsWithRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun contains(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<ContainsRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun oneOf(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<OneOfRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun notOneOf(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<NotOneOfRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun enum(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<EnumRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun json(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<JsonRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun luhn(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<LuhnRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    // ========================================
    // REACTIVE MONO EXAMPLES - validateMono()
    // ========================================
    // These examples show the reactive Mono-based validation approach
    // instead of the suspend function approach used above.
    // Both are fully non-blocking!

    /**
     * Example using validateMono() with traditional reactive Mono chains.
     * This is an alternative to the suspend function approach.
     */
    fun emailReactive(request: ServerRequest): reactor.core.publisher.Mono<ServerResponse> {
        return request.bodyToMono(EmailRequest::class.java)
            .flatMap { payload ->
                // Validate using reactive Mono - fully non-blocking
                EmailRequestValidator()
                    .validateMono(payload, request, contextProvider.getBase())
                    .thenReturn(payload)
            }
            .flatMap { payload ->
                ServerResponse.ok().bodyValue(DataResponse(data = payload, message = "Validation successful (reactive)"))
            }
    }

    /**
     * Example showing error handling with validateMono().
     * ValidationException is propagated through the Mono chain.
     */
    fun urlReactive(request: ServerRequest): reactor.core.publisher.Mono<ServerResponse> {
        return request.bodyToMono(UrlRequest::class.java)
            .flatMap { payload ->
                UrlRequestValidator()
                    .validateMono(payload, request, contextProvider.getBase())
                    .thenReturn(payload)
            }
            .flatMap { payload ->
                ServerResponse.ok().bodyValue(DataResponse(data = payload, message = "Validation successful (reactive)"))
            }
            // Error handling happens via ApplicationExceptionHandler
    }

    /**
     * Example combining multiple operations in a reactive chain.
     * Shows how validateMono() fits naturally into reactive pipelines.
     */
    fun uuidReactive(request: ServerRequest): reactor.core.publisher.Mono<ServerResponse> {
        return request.bodyToMono(UuidRequest::class.java)
            .doOnNext { payload -> println("Received payload: $payload") }
            .flatMap { payload ->
                UuidRequestValidator()
                    .validateMono(payload, request, contextProvider.getBase())
                    .thenReturn(payload)
            }
            .map { payload -> payload.copy(uuid = payload.uuid?.uppercase()) } // Transform after validation
            .flatMap { payload ->
                ServerResponse.ok().bodyValue(
                    DataResponse(
                        data = payload,
                        message = "Validation successful (reactive with transformation)"
                    )
                )
            }
    }
}