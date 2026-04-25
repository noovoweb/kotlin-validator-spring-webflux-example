package com.noovoweb.project.request.structural

import com.noovoweb.validator.Valid
import com.noovoweb.validator.Validated
import com.noovoweb.validator.Email

@Validated
data class Address(
    @Email
    val email: String?
)

@Validated
data class ValidRequest(
    @Valid
    val address: Address?
)
