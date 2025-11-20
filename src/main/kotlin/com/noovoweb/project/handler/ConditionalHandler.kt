package com.noovoweb.project.handler

import com.noovoweb.validator.spring.validate

import com.noovoweb.project.request.conditional.*
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.spring.ValidationContextProvider
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class ConditionalHandler(
    private val contextProvider: ValidationContextProvider
) {

    suspend fun same(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<SameRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun different(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<DifferentRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun requiredIf(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<RequiredIfRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun requiredUnless(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<RequiredUnlessRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun requiredWith(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<RequiredWithRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun requiredWithout(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<RequiredWithoutRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

}
