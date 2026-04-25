package com.noovoweb.project.request.conditional

import com.noovoweb.validator.Same
import com.noovoweb.validator.Validated

@Validated
data class SameRequest(
    val password: String?,
    @Same(field = "password")
    val confirmPassword: String?
)
