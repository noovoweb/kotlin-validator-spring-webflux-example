package com.noovoweb.project.request.network

import com.noovoweb.validator.IPv6
import com.noovoweb.validator.Validated

@Validated
data class IPv6Request(
    @IPv6
    val ipAddress: String?
)
