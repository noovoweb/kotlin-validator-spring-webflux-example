package com.noovoweb.project.request.network

import com.noovoweb.validator.MacAddress
import com.noovoweb.validator.Validated

@Validated
data class MacAddressRequest(
    @MacAddress
    val macAddress: String?
)
