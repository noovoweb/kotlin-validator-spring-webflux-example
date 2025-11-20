package com.noovoweb.project.handler

import com.noovoweb.validator.spring.validate

import com.noovoweb.project.request.datetime.*
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.spring.ValidationContextProvider
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class DateTimeHandler(
    private val contextProvider: ValidationContextProvider
) {

    suspend fun dateFormat(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<DateFormatRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun isoDate(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<IsoDateRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun isoDateTime(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<IsoDateTimeRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun future(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<FutureRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun past(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<PastRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun today(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<TodayRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

}
