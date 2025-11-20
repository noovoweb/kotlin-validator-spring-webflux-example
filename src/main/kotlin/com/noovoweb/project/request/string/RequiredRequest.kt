package com.noovoweb.project.request.string

import com.noovoweb.validator.Required
import com.noovoweb.validator.Validated

@Validated
data class RequiredRequest(
    @Required
    val name: String?
)
