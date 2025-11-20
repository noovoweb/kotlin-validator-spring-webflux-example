package com.noovoweb.project.request.network

import com.noovoweb.validator.IP
import com.noovoweb.validator.Validated

@Validated
data class IPRequest(
    @IP
    val ipAddress: String?
)
