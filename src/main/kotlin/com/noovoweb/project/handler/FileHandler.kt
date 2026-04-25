package com.noovoweb.project.handler

import com.noovoweb.validator.spring.validate

import com.noovoweb.project.request.file.*
import com.noovoweb.project.response.DataResponse
import com.noovoweb.validator.spring.ValidationContextProvider
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class FileHandler(
    private val contextProvider: ValidationContextProvider
) {

    suspend fun mimeType(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<MimeTypeRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun fileExtension(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<FileExtensionRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

    suspend fun maxFileSize(request: ServerRequest): ServerResponse {
        val payload = request.awaitBody<MaxFileSizeRequest>()
        payload.validate(request, contextProvider.getBase())
        return ServerResponse.ok().bodyValueAndAwait(DataResponse(data = payload, message = "Validation successful"))
    }

}
