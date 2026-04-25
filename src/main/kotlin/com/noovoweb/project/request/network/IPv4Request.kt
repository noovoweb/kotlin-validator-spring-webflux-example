package com.noovoweb.project.request.network

import com.noovoweb.validator.IPv4
import com.noovoweb.validator.Validated

@Validated
data class IPv4Request(
    @IPv4
    val ipAddress: String?
)
