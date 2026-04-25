package com.noovoweb.project.request.numeric

import com.noovoweb.validator.DecimalPlaces
import com.noovoweb.validator.Validated

@Validated
data class DecimalPlacesRequest(
    @DecimalPlaces(2)
    val price: String?
)
