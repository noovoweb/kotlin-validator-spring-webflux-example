package com.noovoweb.project.request.string

import com.noovoweb.validator.Luhn
import com.noovoweb.validator.Validated

@Validated
data class LuhnRequest(
    @Luhn
    val cardNumber: String?
)
