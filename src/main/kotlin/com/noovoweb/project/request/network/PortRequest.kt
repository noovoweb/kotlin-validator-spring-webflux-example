package com.noovoweb.project.request.network

import com.noovoweb.validator.Port
import com.noovoweb.validator.Validated

@Validated
data class PortRequest(
    @Port
    val port: Int?
)
