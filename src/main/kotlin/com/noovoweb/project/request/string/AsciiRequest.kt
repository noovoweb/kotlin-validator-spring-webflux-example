package com.noovoweb.project.request.string

import com.noovoweb.validator.Ascii
import com.noovoweb.validator.Validated

@Validated
data class AsciiRequest(
    @Ascii
    val value: String?
)
