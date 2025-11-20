package com.noovoweb.project.handler

import com.noovoweb.validator.spring.validate

import com.noovoweb.project.request.numeric.*
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.spring.ValidationContextProvider
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class NumericHandler(
    private val contextProvider: ValidationContextProvider
) {

    suspend fun min(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<MinRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun max(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<MaxRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun between(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<BetweenRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun positive(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<PositiveRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun negative(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<NegativeRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun zero(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<ZeroRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun integer(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<IntegerRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun decimal(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<DecimalRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun divisibleBy(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<DivisibleByRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun even(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<EvenRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun odd(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<OddRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun decimalPlaces(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<DecimalPlacesRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

}
