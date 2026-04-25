package com.noovoweb.project.request.string

import com.noovoweb.validator.Enum
import com.noovoweb.validator.Validated

enum class Status {
    ACTIVE,
    INACTIVE,
    PENDING
}

@Validated
data class EnumRequest(
    @Enum(Status::class)
    val status: String?
)
