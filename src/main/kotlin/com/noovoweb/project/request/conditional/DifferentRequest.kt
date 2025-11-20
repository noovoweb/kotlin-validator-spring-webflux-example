package com.noovoweb.project.request.conditional

import com.noovoweb.validator.Different
import com.noovoweb.validator.Validated

@Validated
data class DifferentRequest(
    val username: String?,
    @Different(field = "username")
    val email: String?
)
