package com.noovoweb.project.request.string

import com.noovoweb.validator.Url
import com.noovoweb.validator.Validated

@Validated
data class UrlRequest(
    @Url
    val url: String?
)
