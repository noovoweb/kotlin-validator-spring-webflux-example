package com.noovoweb.project.request.string

import com.noovoweb.validator.Uuid
import com.noovoweb.validator.Validated

@Validated
data class UuidRequest(
    @Uuid
    val uuid: String?
)
