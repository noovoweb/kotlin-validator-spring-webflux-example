package com.noovoweb.project.request.boolean

import com.noovoweb.validator.Accepted
import com.noovoweb.validator.Validated

@Validated
data class AcceptedRequest(
    @Accepted
    val value: String?
)
