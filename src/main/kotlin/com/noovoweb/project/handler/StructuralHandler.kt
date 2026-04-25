package com.noovoweb.project.handler

import com.noovoweb.validator.spring.validate

import com.noovoweb.project.request.structural.*
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.spring.ValidationContextProvider
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class StructuralHandler(
    private val contextProvider: ValidationContextProvider
) {

    suspend fun valid(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<ValidRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun failFast(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<FailFastRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }
}
