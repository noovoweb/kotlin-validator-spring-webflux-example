package com.noovoweb.project.request.string

import com.noovoweb.validator.Alpha
import com.noovoweb.validator.Validated

@Validated
data class AlphaRequest(
    @Alpha
    val value: String?
)
