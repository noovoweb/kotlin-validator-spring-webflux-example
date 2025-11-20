package com.noovoweb.project.request.structural

import com.noovoweb.validator.FailFast
import com.noovoweb.validator.MinLength
import com.noovoweb.validator.Validated

@Validated
data class FailFastRequest(
    @FailFast
    @MinLength(5)
    val value: String?
)
