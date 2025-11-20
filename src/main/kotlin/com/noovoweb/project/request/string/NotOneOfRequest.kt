package com.noovoweb.project.request.string

import com.noovoweb.validator.NotOneOf
import com.noovoweb.validator.Validated

@Validated
data class NotOneOfRequest(
    @NotOneOf(values = ["admin", "root", "system"])
    val username: String?
)
