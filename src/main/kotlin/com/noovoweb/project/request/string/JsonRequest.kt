package com.noovoweb.project.request.string

import com.noovoweb.validator.Json
import com.noovoweb.validator.Validated

@Validated
data class JsonRequest(
    @Json
    val data: String?
)
