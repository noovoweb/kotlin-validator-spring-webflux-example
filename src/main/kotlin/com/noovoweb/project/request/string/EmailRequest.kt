package com.noovoweb.project.request.string

import com.noovoweb.validator.Email
import com.noovoweb.validator.Validated

@Validated
data class EmailRequest(
    @Email
    val email: String?
)
