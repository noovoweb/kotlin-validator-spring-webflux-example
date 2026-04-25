package com.noovoweb.project.request.string

import com.noovoweb.validator.OneOf
import com.noovoweb.validator.Validated

@Validated
data class OneOfRequest(
    @OneOf(values = ["active", "inactive", "pending"])
    val status: String?
)
